package com.standalone.core.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.standalone.core.ui.dp2px
import com.standalone.core.ui.getAvatar

class MultiTouchView2(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val bitmap = getAvatar(resources, dp2px(200f).toInt())
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var downX = 0f
    var downY = 0f
    var offsetX = 0f
    var offsetY = 0f
    var originalOffsetX = 0f
    var originalOffsetY = 0f


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var sumX = 0f
        var sumY = 0f

        var pointerCount = event.pointerCount
        val isPointerUp = event.actionMasked == MotionEvent.ACTION_POINTER_UP
        for (i in 0 until pointerCount) {
            //如果是抬起事件，则不计算该事件的 sum
            if (!(isPointerUp && i == event.actionIndex)) {
                sumX += event.getX(i)
                sumY += event.getY(i)
            }
        }
        if (isPointerUp) --pointerCount
        val focusX = sumX / pointerCount
        val focusY = sumY / pointerCount

        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> down(focusX, focusY)
            MotionEvent.ACTION_POINTER_DOWN -> down(focusX, focusY)
            MotionEvent.ACTION_POINTER_UP -> down(focusX, focusY)
            MotionEvent.ACTION_MOVE -> {
                //拿到 index 位置 event.getX(tackingPointerId)
                offsetX = focusX - downX + originalOffsetX
                offsetY = focusY - downY + originalOffsetY
                invalidate()
            }
        }
        return true
    }

    private fun down(focusX: Float, focusY: Float) {
        downX = focusX
        downY = focusY
        originalOffsetX = offsetX
        originalOffsetY = offsetY
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

}