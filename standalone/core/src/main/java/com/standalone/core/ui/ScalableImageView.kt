package com.standalone.core.ui

import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.OverScroller
import androidx.core.view.GestureDetectorCompat

class ScalableImageView(context: Context?, attrs: AttributeSet?) : View(context, attrs),
    GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var bitmap: Bitmap = getAvatar(resources, dp2px(200f).toInt())

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

    //缩小比例
    var smallScale = 0f

    //放大比例
    var bigScale = 0f

    //对放大比例再次进行放大，比例为 1.5
    var overScaleFactor = 1.5f

    //是否为大图
    var big = false

    //缩放动画比例
    var scaleFraction = 0f
        set(value) {
            field = value
            invalidate()
        }

    //动画
    var scaleAnimation: ObjectAnimator? = null
        get() {
            if (field == null) {
                scaleAnimation = ObjectAnimator.ofFloat(this, "scaleFraction", 0f, 1f)
            }
            return field!!
        }

    //手势处理
    private var detector: GestureDetectorCompat = GestureDetectorCompat(context, this)

    //计算滑动的偏移，常用语于 onFling 方法中
    private var scroller = OverScroller(context)


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        originalOffsetX = (width - bitmap.width) / 2f
        originalOffsetY = (height - bitmap.height) / 2f

        //图片的宽高比如果大于 view 的宽高比，表示图片更宽
        if (bitmap.width.toFloat() / bitmap.height > width.toFloat() / height) {
            //图片更宽，表示宽度要放大到等于 View 的宽度，比例为：view宽度 / 图片宽度
            //缩小比例
            smallScale = width.toFloat() / bitmap.width
            //放大比例
            bigScale = height.toFloat() / bitmap.height * overScaleFactor
        } else {
            //和上面相反
            smallScale = height.toFloat() / bitmap.height
            bigScale = width.toFloat() / bitmap.width * overScaleFactor
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return detector.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        canvas.translate(offsetX, offsetY)
        //计算实时缩放的百分比
        // scaleFraction 为 0 ，则 scale 为 smallScale
        // scaleFraction 为 1 ，则 scale 为 bigScale
        val scale = smallScale + (bigScale - smallScale) * scaleFraction
        canvas.scale(scale, scale, (width / 2).toFloat(), (height / 2).toFloat())
        canvas.drawBitmap(bitmap, originalOffsetX, originalOffsetY, paint)
    }

    //双击事件
    override fun onDoubleTap(e: MotionEvent?): Boolean {
        big = !big
        if (big) {
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


    override fun onDown(e: MotionEvent?): Boolean {
        return true
    }

    //欲按下，按下后会等待100毫秒执行此方法
    override fun onShowPress(e: MotionEvent?) {

    }

    //单击事件
    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return false
    }

    //长按事件
    override fun onLongPress(e: MotionEvent?) {

    }


    //如果实现了双击，那么单击需要使用此方法来完成
    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        return false
    }


    //双击间隔中发生的动作
    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        return false
    }
}