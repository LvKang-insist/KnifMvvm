package com.standalone.core.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * 时间轴，类似于物流详情旁边的竖线
 * 需配合 recyclerview 使用
 */
class LineCircle(context: Context?, attrs: AttributeSet?) :
    View(context, attrs) {
    private val paint =
        Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    /**
     * 线的颜色
     */
    private var mPathColor = Color.parseColor("#eeeeee")

    /**
     * 外圆的颜色
     */
    private val outerCircleColor = Color.parseColor("#96ccff")

    /**
     * 内圆的颜色
     */
    private val innerCircleColor = Color.parseColor("#2988e2")

    /**
     * 是否为头部
     */
    private var mHead = false

    /**
     * 是否发为尾部
     */
    private var mEnd = false

    /**
     * 是否选中当前
     */
    private var isSelect = false

    /**
     * 圆心在高度上的百分比
     */
    private var mScale = 0.3f
    override fun onDraw(canvas: Canvas) {
        val width = width

        // 计算高度的百分比
        val scaleHeight = (height * mScale).toInt()

        //外圆半径
        val radius1 = width / 2
        //内圆半径
        val radius2 = (width * 0.8 / 2).toInt()
        paint.color = mPathColor
        paint.strokeWidth = dip2px(1f).toFloat()
        path.moveTo(width / 2.toFloat(), 50f)
        path.lineTo(width / 2.toFloat(), height.toFloat())

        //画线
        if (mHead) {
            canvas.drawLine(
                radius1.toFloat(),
                scaleHeight.toFloat(),
                radius1.toFloat(),
                height.toFloat(),
                paint
            )
        } else if (mEnd) {
            canvas.drawLine(radius1.toFloat(), 0f, radius1.toFloat(), scaleHeight.toFloat(), paint)
        } else {
            canvas.drawLine(radius1.toFloat(), 0f, radius1.toFloat(), height.toFloat(), paint)
        }
        //画圆
        if (isSelect) {
            paint.color = outerCircleColor
            canvas.drawCircle(radius1.toFloat(), scaleHeight.toFloat(), radius1.toFloat(), paint)
            paint.color = innerCircleColor
            canvas.drawCircle(radius1.toFloat(), scaleHeight.toFloat(), radius2.toFloat(), paint)
        } else {
            paint.color = mPathColor
            canvas.drawCircle(radius1.toFloat(), scaleHeight.toFloat(), dip2px(3f).toFloat(), paint)
        }
    }

    /**
     * 是否为第一个
     */
    fun setHead(head: Boolean) {
        mHead = head
        invalidate()
    }

    /**
     * 是否为最后一个
     *
     * @param end
     */
    fun setEnd(end: Boolean) {
        mEnd = end
        invalidate()
    }

    /**
     * 设置线的颜色
     *
     * @param color
     */
    fun pathColor(color: Int) {
        mPathColor = color
        invalidate()
    }

    /**
     * 设置圆高度的百分比
     *
     * @param mScale
     */
    fun setScale(mScale: Float) {
        this.mScale = mScale
        invalidate()
    }

    /**
     * 是否选中
     *
     * @param isSelect
     */
    fun setSelect(isSelect: Boolean) {
        this.isSelect = isSelect
        invalidate()
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private fun dip2px(dpValue: Float): Int {
        val scale = resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}