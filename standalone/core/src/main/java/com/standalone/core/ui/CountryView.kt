package com.standalone.core.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CountryView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var text = "岐山"
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.textSize = dp2px(50f)
        paint.textAlign = Paint.Align.CENTER
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawText(text, (width / 2).toFloat(), (height / 2).toFloat(), paint)
    }
}