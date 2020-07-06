package com.standalone.core.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.elvishew.xlog.XLog
import java.lang.reflect.Type

/**
 * 绘制文本，位置
 */
class SportView : View {

    private val strokeWidth = dp2px(10F)
    private val radius = dp2px(150F)

    val rect = Rect()


    val fontMetrics = Paint.FontMetrics()

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        paint.textSize = dp2px(80f)
        //设置字体
//        paint.setTypeface(Typeface.createFromFile(""))
        paint.typeface = Typeface.DEFAULT
        //文字位置
        paint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //圆环
        paint.style = Paint.Style.STROKE
        paint.color = Color.BLACK
        paint.strokeWidth = strokeWidth
        canvas.drawCircle(
            (width / 2).toFloat(), (height / 2).toFloat(),
            radius, paint
        )
        //绘制进度条
        paint.color = Color.BLUE
        paint.strokeCap = Paint.Cap.ROUND
        canvas.drawArc(
            width / 2 - radius, height / 2 - radius,
            width / 2 + radius, height / 2 + radius,
            -90f, 180f, false, paint
        )

        //绘制文字
        paint.color = Color.RED
        paint.style = Paint.Style.FILL



        paint.textAlign = Paint.Align.CENTER
        paint.getFontMetrics(fontMetrics)
//        val offset = (fontMetrics.ascent + fontMetrics.descent) / 2
//        canvas.drawText("aaaa", (width / 2).toFloat(), (height / 2).toFloat() - offset, paint)


        paint.getTextBounds("aaaa", 0, "aaaa".length, rect)
        paint.textSize = 150f
        paint.textAlign = Paint.Align.LEFT
        canvas.drawText("aaaa", -(rect.left.toFloat()), 0f, paint)

    }

}