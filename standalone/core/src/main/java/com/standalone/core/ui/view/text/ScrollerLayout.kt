package com.standalone.core.ui.view.text

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.*
import android.widget.OverScroller
import androidx.core.view.GestureDetectorCompat
import androidx.core.view.ViewConfigurationCompat
import com.elvishew.xlog.XLog
import kotlin.math.abs

/**
 * @name Android Business Toos
 * @class name：com.business.tools.views.page
 * @author 345 QQ:1831712732
 * @time 2020/4/11 20:46
 * @description
 */

class ScrollerLayout : ViewGroup {

    /**
     * 用于完成滚动操作的实例
     */
    private var scroller = OverScroller(context)

    //手势侦测器
    private var gestureListenerImpl = GestureListenerImpl()
    private var detector: GestureDetectorCompat =
        GestureDetectorCompat(getContext(), gestureListenerImpl)

    /**
     * 判定为拖动的最小移动像素
     */
    private var mTouchSlop = 0

    /**
     * 按下时的屏幕坐标
     */
    private var mYDown = 0f

    /**
     * 移动时所处的屏幕坐标
     */
    private var mYMove = 0f

    /**
     * 手指离开屏幕的坐标
     */
    private var mYUp = 0f

    /**
     * 上次触发 MOVE 事件的屏幕坐标
     */
    private var mYLastMove = 0f

    /**
     * 界面可滚动的左边界
     */
    private var topBorder = 0

    /**
     * 界面可滚动的由边界
     */
    private var bottomBorder = 0

    /**
     * 滑动后的位置
     */
    private var targetIndex = -1

    /**
     * 下标
     */
    var mPosition: Int = 0

    private var layoutInflater = LayoutInflater.from(context)


    var mLastFlingY = 0

    var mWidth = 0
    var mHeight = 0

    var selectHeightTop = 0
    var selectHeightBottom = 0

    var childHeight = 0


    var mVelocityTracker: VelocityTracker = VelocityTracker.obtain()


    var mMaximumFlingVelocity:Int = 0
    var mMinimumFlingVelocity:Int = 0

    /**
     * 适配器
     */
    var adapter: PageAdapter? = null
        set(value) {
            field = value
            startItem()
        }


    constructor(context: Context) : this(context, null)
    constructor(context: Context, attributeSet: AttributeSet?) : super(context, attributeSet) {
        //最小移动距离
        mTouchSlop = ViewConfigurationCompat.getScaledHoverSlop(ViewConfiguration.get(context))

        //让当前view 可以点击
        isClickable = true


        val configuration = ViewConfiguration.get(getContext())
        mTouchSlop = ViewConfigurationCompat.getScaledPagingTouchSlop(configuration)
        mMinimumFlingVelocity = configuration.scaledMinimumFlingVelocity
        mMaximumFlingVelocity =
            configuration.scaledMaximumFlingVelocity / 8

    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        for (i in 0 until childCount) {
            val childView = getChildAt(i)
            //测量子控件的大小
            measureChild(childView, widthMeasureSpec, heightMeasureSpec)
            if (getChildAt(i).measuredHeight > childHeight) {
                childHeight = getChildAt(i).measuredHeight
            }
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        val centre = childHeight / 2
        selectHeightTop = height / 2 - centre
        selectHeightBottom = height / 2 + centre

        XLog.e("$selectHeightTop --- $selectHeightBottom")
    }

    /**
     * 创建视图
     */
    private fun startItem() {
        val count = adapter?.count()
        val listOf = mutableListOf<View>()

        for (i in 0 until count!!) {
            val iv = layoutInflater.inflate(
                adapter?.layoutRes!!, this, false
            )
            listOf.add(iv)
        }
        drawItem(listOf)
    }

    /**
     * 绘制 Item，并回调适配器
     */
    private fun drawItem(views: MutableList<View>) {
        views.forEach {
            addView(it)
        }
        invalidate()

        for (i in 0 until views.size) {
            adapter?.view(views[i], i)
        }
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        if (changed && childCount > 0) {
            val childCount = childCount

            var top = 0
            for (i in 0 until childCount) {
                val childView = getChildAt(i)

                val bottom = top + childView.measuredHeight
                val right = 0 + childView.measuredWidth
                if (bottom > mHeight) {
                    mHeight = bottom
                }
                if (right > mWidth) {
                    mWidth = right
                }
                childView.layout(
                    0, i * childView.measuredHeight,
                    childView.measuredWidth, (i + 1) * childView.measuredHeight
                )
                top += childView.measuredHeight
            }
            //获取左右边界
            topBorder = getChildAt(0).top
            bottomBorder = getChildAt(childCount - 1).bottom
        }
    }

    override fun onInterceptTouchEvent(ev: MotionEvent): Boolean {
        when (ev.action) {
            MotionEvent.ACTION_DOWN -> {
                //rawX ，相对于屏幕的横坐标
                mYDown = ev.rawY
                mYLastMove = mYDown
            }
            MotionEvent.ACTION_MOVE -> {
                mYMove = ev.rawY
                //移动的距离
                val diff = abs(mYMove - mYDown)
                mYLastMove = mYMove
                //当手指拖动大于 TouchSlop 值时，认为应该进行滚动，拦截子控件的时间
                if (diff > mTouchSlop) {
                    return true
                }
            }
        }
        return super.onInterceptTouchEvent(ev)
    }


    /**
     * 双击，滑动等处理
     */
    inner class GestureListenerImpl : GestureDetector.OnGestureListener {


        override fun onScroll(
            e1: MotionEvent?, event: MotionEvent, distanceX: Float, distanceY: Float
        ): Boolean {
            mVelocityTracker.addMovement(event)
            when (event.action) {
                MotionEvent.ACTION_MOVE -> {
                    mYMove = event.rawY
                    //移动的距离
                    val scrolledY = (mYLastMove - mYMove).toInt()
                    //边界处理，拖出边界后就使用 scrollTo 回到边界位置
                    if (scrollY + scrolledY < topBorder) {
                        scrollTo(0, topBorder)
                        return true
                    } else if (scrollY + height + scrolledY > bottomBorder) {
                        scrollTo(0, bottomBorder - height)
                        return true
                    }
                    //移动

                    mYLastMove = mYMove
                }
                MotionEvent.ACTION_UP -> {


                    val velocity = mVelocityTracker
                    velocity.computeCurrentVelocity(1000,mMaximumFlingVelocity.toFloat())




                    //当手指抬起时，根据当前滚动值来判定应该滚动到那个子控件界面
//                //计算收松开后要显示的页面 index
////                targetIndex = if (mYDown > event.rawY) {
////                    (scrollY + (height * 0.7).toInt()) / height
////                } else {
////                    (scrollY + (height * 0.3).toInt()) / height
////                }
////                val dy = targetIndex * height - scrollY
                    //调用 startScroll 方法来初始化数据并刷新界面
//                    if (scrollY == 0) {
//                        return false
//                    } else if (mHeight == scrollY) {
//                        return false
//                    }
//                    scroller.startScroll(0, mYUp.toInt(), 0, 1000)

//                    scrollBy(0, 1000)

//                    mLastFlingY = scrollY
//                    mPosition = targetIndex - 1
//                    invalidate()
                }
            }
            return false
        }


        override fun onFling(
            e1: MotionEvent?, event: MotionEvent, velocityX: Float, velocityY: Float
        ): Boolean {

            return false
        }



        override fun onLongPress(e: MotionEvent?) {

        }

        override fun onShowPress(e: MotionEvent?) {

        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            return false
        }

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }


    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        return detector.onTouchEvent(event)
    }


}