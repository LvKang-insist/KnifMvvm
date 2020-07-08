package com.standalone.core.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Point
import android.util.AttributeSet
import android.view.View

class PointView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint()

    var point = Point()
        set(value) {
            field = value
            invalidate()
        }

    init {
        paint.color = Color.RED
        paint.strokeWidth = dp2px(15f)
        paint.strokeCap = Paint.Cap.ROUND
        point.x = 10
        point.y = 10
    }


    override fun draw(canvas: Canvas) {
        super.draw(canvas)
        canvas.drawPoint(point.x.toFloat(), point.y.toFloat(), paint)
    }
}