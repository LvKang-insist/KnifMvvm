package com.standalone.core.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.SparseArray
import android.view.MotionEvent
import android.view.View
import androidx.core.util.forEach
import com.standalone.core.ui.dp2px
import com.standalone.core.ui.getAvatar

/**
 * 互不干扰型
 */
class MultiTouchView3(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var paths = SparseArray<Path>()

    init {
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = dp2px(4f)
        paint.strokeCap = Paint.Cap.ROUND
        paint.strokeJoin = Paint.Join.ROUND
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                val index = event.actionIndex
                val pointerId = event.getPointerId(index)
                val path = Path()
                path.moveTo(event.getX(index), event.getY(index))
                paths.append(pointerId, path)
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                val index = event.actionIndex
                val pointerId = event.getPointerId(index)
                val path = Path()
                path.moveTo(event.getX(index), event.getY(index))
                paths.append(pointerId, path)
            }
            MotionEvent.ACTION_MOVE -> {
                val count = event.pointerCount
                for (i in 0 until count) {
                    val pointId = event.getPointerId(i)
                    val index = event.findPointerIndex(pointId)
                    val path = paths[pointId]
                    path.lineTo(event.getX(index), event.getY(index))
                }
                invalidate()
            }
            MotionEvent.ACTION_POINTER_UP -> {
                val pointerId = event.getPointerId(event.actionIndex)
                paths.remove(pointerId)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                val pointerId = event.getPointerId(event.actionIndex)
                paths.remove(pointerId)
                invalidate()
            }
        }
        return true
    }


    override fun onDraw(canvas: Canvas) {
        paths.forEach { key, value ->
            canvas.drawPath(value, paint)
        }
    }

}