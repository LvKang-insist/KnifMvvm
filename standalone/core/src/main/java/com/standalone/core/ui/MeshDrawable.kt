package com.standalone.core.ui

import android.graphics.*
import android.graphics.drawable.Drawable

/**
 * @name MeshDrawable
 * @package com.standalone.core.ui
 * @author 345 QQ:1831712732
 * @time 2020/7/8 21:08
 * @description 网眼 Drawable
 */
class MeshDrawable : Drawable() {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    /**
     * 间隔
     */
    val interval = dp2px(80f).toInt()

    init {
        paint.color = Color.RED
        paint.strokeWidth = dp2px(3f)
    }

    override fun draw(canvas: Canvas) {
        var i = 0
        while (i < bounds.right) {
            i += interval
            var j = 0
            while (j < bounds.bottom) {
                j += interval
                canvas.drawLine(
                    bounds.left.toFloat(), j.toFloat(),
                    bounds.right.toFloat(), j.toFloat(), paint
                )
                canvas.drawLine(
                    i.toFloat(), bounds.top.toFloat(),
                    i.toFloat(), bounds.bottom.toFloat(), paint
                )
            }
        }
    }

    /**
     * 设置透明度
     */
    override fun setAlpha(alpha: Int) {
        paint.alpha = alpha
    }

    override fun getAlpha(): Int {
        return paint.alpha
    }

    /**
     * 设置颜色过滤
     */
    override fun setColorFilter(colorFilter: ColorFilter?) {
        paint.colorFilter = colorFilter
    }

    /**
     * 该图像是完全透明，还是部分透明，或者是完全不透明
     * TRANSPARENT：透明
     * OPAQUE:不透明   0xff:255
     * TRANSLUCENT：半透明
     */
    override fun getOpacity(): Int {
        if (paint.alpha == 0) {
            return PixelFormat.TRANSPARENT
        } else if (paint.alpha == 0xff) {
            return PixelFormat.OPAQUE
        } else {
            return PixelFormat.TRANSLUCENT
        }
    }
}