package com.standalone.core.ui

import android.content.Context
import android.graphics.Camera
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * 裁切
 */
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint()

    val camera = Camera()

    var bitmapWidth: Int = dp2px(300f).toInt()

    var mLeft = 100f
    var mTop = 100f


    /**
     * 上面翻起的度数
     */
    var topFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    /**
     * 下面翻起的度数
     */
    var bottomFlip = 0f
        set(value) {
            field = value
            invalidate()
        }

    /**
     * 旋转角度
     */
    var flipRotation = 0f
        set(value) {
            field = value
            invalidate()
        }

    val bitmap = getAvatar(resources, bitmapWidth)

    init {
        camera.setLocation(0f, 0f, getZForCamera())
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)


        canvas.save()
        //上半部分
        canvas.translate((mLeft + (bitmapWidth / 2)), (mTop + (bitmapWidth / 2).toFloat()))
        canvas.rotate(-flipRotation)
        camera.save()
        camera.rotateX(topFlip)
        camera.applyToCanvas(canvas)
        camera.restore()
        //切割
        canvas.clipRect(-bitmapWidth, -bitmapWidth, bitmapWidth, 0)
        canvas.rotate(flipRotation)
        //移动到左上角
        canvas.translate(-(mLeft + (bitmapWidth / 2)), -(mTop + (bitmapWidth / 2)))
        //绘制
        canvas.drawBitmap(bitmap, mLeft, mTop, paint)
        canvas.restore()

        //下半部分
        canvas.translate((mLeft + (bitmapWidth / 2)), mTop + (bitmapWidth / 2).toFloat())
//        //旋转回来
        canvas.rotate(-flipRotation)

        camera.save()
        //X 轴旋转
        camera.rotateX(bottomFlip)
//        投影
        camera.applyToCanvas(canvas)
        camera.restore()
        //切割
        canvas.clipRect(-bitmapWidth, 0, bitmapWidth, bitmapWidth)
        //旋转
        canvas.rotate(flipRotation)
        //移动到左上角
        canvas.translate(
            -(mLeft + (bitmapWidth / 2).toFloat()),
            -(mTop + (bitmapWidth / 2).toFloat())
        )
        //绘制
        canvas.drawBitmap(bitmap, mLeft, mTop, paint)
    }
}