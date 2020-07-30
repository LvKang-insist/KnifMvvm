package com.standalone.core.ui.view

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.ScaleGestureDetector
import android.view.View
import android.widget.OverScroller
import androidx.core.view.GestureDetectorCompat
import com.standalone.core.ui.dp2px
import com.standalone.core.ui.getAvatar

class ScalableImageView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap = getAvatar(
        resources,
        dp2px(200f).toInt()
    )

    //初始偏移
    var originalOffsetX = 0f
    var originalOffsetY = 0f

    //移动的偏移
    var offsetX = 0f
    var offsetY = 0f

    /**
     * 缩放比例：
     *  图片左贴 View 的左，右贴 View 的右面。上下留空
     *  图片上贴 view 的上，下贴 view 的下面。如果图片有点胖，两边可能会出去
     */
    //小尺寸
    var smallScale = 0f

    //大尺寸
    var bigScale = 0f

    //对放大比例再次进行放大，比例为 1.5
    var overScaleFactor = 1.5f

    //是否为大图
    var big = false

    //动画
    var scaleAnimation: ObjectAnimator? = null
        get() {
            if (field == null) {
                field = ObjectAnimator.ofFloat(this, "currentScale", smallScale, bigScale)
            }
            //在每次获取动画的1时候都需要设置开始和结束值
            field!!.setFloatValues(smallScale, bigScale)
            return field
        }

    //缩放动画比例
    var currentScale = 0f
        set(value) {
            field = value
            invalidate()
        }

    private var gestureListenerImpl = GestureListenerImpl()

    //手势侦测器
    private var detector: GestureDetectorCompat =
        GestureDetectorCompat(getContext(), gestureListenerImpl)

    //计算滑动的偏移，常用于 onFling 方法中
    private var scroller = OverScroller(context)

    //缩放手势侦测器
    private var scaleDetector: ScaleGestureDetector =
        ScaleGestureDetector(getContext(), ScaleGestureListenerImpl())


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        //初始偏移为中心位置
        originalOffsetX = (width - bitmap.width) / 2f
        originalOffsetY = (height - bitmap.height) / 2f

        //图片的宽高比如果大于 view 的宽高比，表示图片更宽
        if (bitmap.width.toFloat() / bitmap.height > width.toFloat() / height) {
            //图片更宽，表示宽度要放大到等于 View 的宽度，比例为：view宽度 / 图片宽度
            //小尺寸
            smallScale = width.toFloat() / bitmap.width
            //大尺寸
            bigScale = height.toFloat() / bitmap.height * overScaleFactor
        } else {
            //和上面相反
            smallScale = height.toFloat() / bitmap.height
            bigScale = width.toFloat() / bitmap.width * overScaleFactor
        }
        currentScale = smallScale
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var result = scaleDetector.onTouchEvent(event)
        if (!scaleDetector.isInProgress) {
            result = detector.onTouchEvent(event)
        }
        return result
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //滑动时的移动
        //scaleFraction ：在缩放的过程中需要进行逐渐的偏移。这样在缩小的时候会缩小的原来的位置，放大的时候会放大到目标位置
        //scaleFraction 的值是一个百分比。从开始状态到结束状态之间的百分比
        //scaleFraction 计算：(当前 - 开始) /(结束 - 开始) 。注意，当前位置(currentScale)是会变得，
        //当 currentScale 为结束后，则计算的结果就会为 0
        val scaleFraction = (currentScale - smallScale) / (bigScale - smallScale)
        canvas.translate(offsetX * scaleFraction, offsetY * scaleFraction)
        //计算实时缩放的百分比
        canvas.scale(currentScale, currentScale, (width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawBitmap(bitmap, originalOffsetX, originalOffsetY, paint)
    }

    inner class ScaleGestureListenerImpl : ScaleGestureDetector.OnScaleGestureListener {
        /**
         * 缩放倍数
         */
        var initialScale = 0f

        /**
         * scale 之前调用，进行初始化等
         */
        override fun onScaleBegin(detector: ScaleGestureDetector): Boolean {
            //detector.scaleFactor：倍数，如手指撑开，则倍数就会变大 1.0,1.1,2,3...，如手指距离变小，则 0.9,0.8 .... 。不会为 0、
            //detector.focusX,y焦点。多个手指按下之后的中心
            initialScale = currentScale
            return true
        }


        /**
         * Scale 过程中，做具体的计算
         */
        override fun onScale(detector: ScaleGestureDetector): Boolean {
            //拿到倍数
            currentScale = initialScale * detector.scaleFactor
            invalidate()
            return false
        }

        /**
         * Scale 完成后，如果需要擦屁股，则擦一擦
         */
        override fun onScaleEnd(detector: ScaleGestureDetector?) {
        }
    }

    /**
     * 双击，滑动等处理
     */
    inner class GestureListenerImpl : GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {
        //双击事件
        override fun onDoubleTap(e: MotionEvent): Boolean {
            big = !big
            if (big) {
                //点击放大后。会出现点击的位置是 10,10。但是放大后为 20,20。所以需要进行偏移回来。
                //计算放大后需要偏移回来的值(保证对点击的位置进行放大)。
                //(e.x - width / 2)：点击位置的偏移
                //(e.x - width / 2) * bigScale / smallScale ：放大后的偏移
                //开始的偏移 - 放大的偏移。为需要偏移回来的值
                offsetX = (e.x - width / 2) - (e.x - width / 2) * bigScale / smallScale
                offsetY = (e.y - height / 2) - (e.y - height / 2) * bigScale / smallScale
                scaleAnimation?.start()
            } else {
                scaleAnimation?.reverse()
            }
            return false
        }

        /**
         * @param e1 按下事件
         * @param e2 当前事件
         * @param distanceX 距离 x，上一个 event 减去 当前 event 的值
         * @param distanceY 距离 y，上一个 event 减去 当前 event 的值
         */
        override fun onScroll(
            e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float
        ): Boolean {
            // 1，为啥要用 减 呢？
            //   例：上一个值 - 当前值为负数，则表示向下移动，所以偏移要增大。所以就是 偏移 - 负数
            //   例：上一个值 - 当前值为正数，则表示向上移动，所以偏移要减小。所以就是 编译 - 正数
            // 2，如果是大图才可以进行移动
            // 3，对移动进行限制，滑动到图片边缘后则禁止滑动，如何判断呢？
            //   (图片的宽度 - View的宽度) /2
            //   因为进行了缩放，所以图片的宽度就是 宽度 * bigScale （bigScale 为最大缩放比例）
            //   所以如果 偏移 > (图片的宽度 - View的宽度) /2 ，则就不需要偏移了，否则进行偏移
            //   注意：判断需要进行两次，因为左右，还有上下，取相反即可
            if (big) {
                offsetX -= distanceX
                offsetX = Math.min(offsetX, (bitmap.width * bigScale - width) / 2)
                offsetX = Math.max(offsetX, -(bitmap.width * bigScale - width) / 2)
                offsetY -= distanceY
                offsetY = Math.min(offsetY, (bitmap.height * bigScale - height) / 2)
                offsetY = Math.max(offsetY, -(bitmap.height * bigScale - height) / 2)
            }
            invalidate()
            return false
        }

        //按下快速滑动后松开，也就是惯性滑动
        override fun onFling(
            e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float
        ): Boolean {
            if (big) {
                //计算图片在 View 外部的宽和高
                val x = ((bitmap.width * bigScale - width) / 2).toInt()
                val y = ((bitmap.height * bigScale - height) / 2).toInt()

                /**
                 * 计算路径
                 * 1,2：初始位置
                 * 3,4：速度
                 * 5,6,7,8：最小X，最大X。最小Y，最大Y
                 * 9,10：过度滚动能超过多少
                 */
                scroller.fling(
                    offsetX.toInt(), offsetY.toInt(),
                    velocityX.toInt(), velocityY.toInt(),
                    -x, x, -y, y,
                    100, 100
                )
                //下一帧执行
                postOnAnimation(this::run)
            }
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

        override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
            return false
        }

        override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
            return false
        }


        private fun run() {
            //更新位置，并返回该动画是否还在执行中，没结束为 true
            if (scroller.computeScrollOffset()) {
                scroller.computeScrollOffset()
                //获取最新位置进行刷新
                offsetX = scroller.currX.toFloat()
                offsetY = scroller.currY.toFloat()
                invalidate()
                postOnAnimation(this::run)
            }
        }
    }
}