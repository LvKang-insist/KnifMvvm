package com.standalone.core.ui

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class TouchView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {


    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.actionMasked) {
            MotionEvent.ACTION_UP -> {
                performClick()
            }
        }
        return true
    }

}