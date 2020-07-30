package com.standalone.core.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.standalone.core.ui.getAvatar

class MultiTouchView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val bitmap = getAvatar(resources, 200)
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var downX = 0f
    var downY = 0f
    var offsetX = 0f
    var offsetY = 0f
    var originalOffsetX = 0f
    var originalOffsetY = 0f


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                downX = event.x
                downY = event.y
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }
            MotionEvent.ACTION_MOVE -> {
                offsetX = event.x - downX
                offsetY = event.y - downY
                invalidate()
            }
        }
        return true
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

}