package com.standalone.core.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class DashBoardView : View {

    /**
     * 开口弧度
     */
    val angle = 120

    val radius = dp2px(150f)

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
        dashPath = PathDashPathEffect(dash, length / 19, 0f, PathDashPathEffect.Style.ROTATE)

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //画线
        canvas.drawArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            90 + angle / 2f, 360f - angle,
            false, paint
        )
        //画刻度
        paint.pathEffect = dashPath
        //画线
        canvas.drawArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            90 + angle / 2f, 360f - angle,
            false, paint
        )
        paint.pathEffect = null
    }
}