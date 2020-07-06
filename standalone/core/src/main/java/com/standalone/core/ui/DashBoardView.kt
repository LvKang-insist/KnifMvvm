package com.standalone.core.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * 绘制刻度
 */
class DashBoardView : View {

    /**
     * 开口弧度
     */
    val angle = 120

    /**
     * 半径
     */
    val radius = dp2px(150f)

    /**
     * 表圈宽度
     */
    val arcWidth = dp2px(5f)

    /**
     * 指针长度
     */
    val length = dp2px(100f)

    /**
     * 指针位置
     */
    val pointerPos = 5

    /**
     * 指针宽度
     */
    val pointerWidth = dp2px(4f)

    /**
     * 刻度数量
     */
    val scaleCount = 20

    /**
     * 刻度宽度
     */
    val scaleWidth = dp2px(2f)


    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val dash = Path()

    var dashPath: PathDashPathEffect? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dp2px(2f)
        paint.strokeWidth = dp2px(8f)
        // dash 一个矩形，顺时针画
        dash.addRect(0f, 0f, dp2px(2f), dp2px(10f), Path.Direction.CW)

        //计算长度
        val arc = Path()
        arc.addArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            90 + angle / 2f, 360f - angle
        )
        val pathMeasure = PathMeasure(arc, false)
        val length = pathMeasure.length - dp2px(2f)
        /**
         * PathDashPathEffect：用指定的形状在路径上画横线
         * 1，指定的形状
         * 2，横线之间的距离
         * 3，距离第一个刻度空多少。
         */
        dashPath =
            PathDashPathEffect(dash, length / (scaleCount - 1), 0f, PathDashPathEffect.Style.ROTATE)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //设置弧度的宽度
        paint.strokeWidth = arcWidth
        //画弧度
        canvas.drawArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            90 + angle / 2f, 360f - angle,
            false, paint
        )

        //刻度的宽度
        paint.strokeWidth = scaleWidth
        //画刻度
        paint.pathEffect = dashPath
        //画弧度
        canvas.drawArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            90 + angle / 2f, 360f - angle,
            false, paint
        )
        paint.pathEffect = null

        // 指针的宽度
        paint.strokeWidth = pointerWidth
        //画指针
        canvas.drawLine(
            (width / 2).toFloat(), (height / 2).toFloat(),
            (Math.cos(Math.toRadians(getAngleFromMark(pointerPos - 1).toDouble())) * length).toFloat() + width / 2,
            (Math.sin(Math.toRadians(getAngleFromMark(pointerPos - 1).toDouble())) * length).toFloat() + height / 2,
            paint
        )
    }


    fun getAngleFromMark(mark: Int): Int {
        return (90 + angle.toFloat() / 2 + (360 - angle.toFloat()) / (scaleCount - 1) * mark).toInt()
    }
}