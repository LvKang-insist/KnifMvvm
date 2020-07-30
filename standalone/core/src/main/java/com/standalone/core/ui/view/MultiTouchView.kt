package com.standalone.core.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import com.standalone.core.ui.dp2px
import com.standalone.core.ui.getAvatar

class MultiTouchView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val bitmap = getAvatar(resources, dp2px(200f).toInt())
    val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    var downX = 0f
    var downY = 0f
    var offsetX = 0f
    var offsetY = 0f
    var originalOffsetX = 0f
    var originalOffsetY = 0f

    //活跃的手指 Id
    var tackingPointerId = 0


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN -> {
                //拿到第0个手指的 Id
                tackingPointerId = event.getPointerId(0)
                downX = event.x
                downY = event.y
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }
            MotionEvent.ACTION_MOVE -> {
                //根据 id 拿到对应的 index
                val index = event.findPointerIndex(tackingPointerId)
                //拿到 index 位置 event.getX(tackingPointerId)
                offsetX = event.getX(index) - downX + originalOffsetX
                offsetY = event.getY(index) - downY + originalOffsetY
                invalidate()
            }
            MotionEvent.ACTION_POINTER_DOWN -> {
                //拿到刚按下去的 index
                val actionIndex = event.actionIndex
                //根据 index 拿到 id ，进行保存
                tackingPointerId = event.getPointerId(actionIndex)
                //将刚按下的手指位置进行保存，保证新的手指可以进行移动
                downX = event.getX(actionIndex)
                downY = event.getY(actionIndex)
                originalOffsetX = offsetX
                originalOffsetY = offsetY
            }
            MotionEvent.ACTION_POINTER_UP -> {
                //拿到抬起手指的 index
                val actionIndex = event.actionIndex
                //根据 index 获取到 id
                val pointerId = event.getPointerId(actionIndex)
                //如果抬起的手指是追踪的手指
                if (tackingPointerId == pointerId) {
                    val newIndex: Int
                    //如果抬起的是最后一个手指，事件需要交给他的前一个手指
                    if (actionIndex == event.pointerCount - 1) {
                        newIndex = event.pointerCount - 2
                    } else {
                        //如果抬起的不是最后一个手指，则事件交给最后一个处理
                        newIndex = event.pointerCount - 1
                    }
                    //获取到新index的 id 进行保存
                    tackingPointerId = event.findPointerIndex(newIndex)
                    //记录新的点的位置和偏移
                    downX = event.getX(newIndex)
                    downY = event.getY(newIndex)
                    originalOffsetX =  offsetX
                    originalOffsetY =  offsetY
                }

            }
        }
        return true
    }


    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, offsetX, offsetY, paint)
    }

}