package com.standalone.core.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

/**'
 *
 * 绘制饼图
 */
class PieChart : View {

    private val radius = dp2px(150f).toInt()
    private val length = dp2px(20f).toInt()
    private val index = 2

    val angles = arrayOf(60, 100, 120, 90)
    val colors = arrayOf(
        Color.parseColor("#81FF6F"),
        Color.parseColor("#FF2A31"),
        Color.parseColor("#F0FF2C"),
        Color.parseColor("#001AFF")
    )


    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    val bounds = RectF()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )


    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        bounds.set(
            (width / 2 - radius).toFloat(), (height / 2 - radius).toFloat(),
            (width / 2 + radius).toFloat(), (height / 2 + radius).toFloat()
        )
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawArc(bounds, 0f, 60f, true, paint)

        var currentAge = 0f
        for (i in 0..3) {
            paint.color = colors[i]
            canvas.save()
            if (i == index) {
                canvas.translate(
                    (Math.cos(Math.toRadians(currentAge + angles[i].toDouble() / 2)) * length).toFloat(),
                    (Math.sin(Math.toRadians(currentAge + angles[i].toDouble() / 2)) * length).toFloat()
                )
            }
            canvas.drawArc(bounds, currentAge, angles[i].toFloat(), true, paint)
            canvas.restore()
            currentAge += angles[i].toFloat()
        }
    }

}