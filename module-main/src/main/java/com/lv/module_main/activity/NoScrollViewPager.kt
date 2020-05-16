package com.lv.module_main.activity

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.viewpager.widget.ViewPager

internal class NoScrollViewPager : ViewPager {
    /**
     * true表示可以滑动，false不能滑动
     */
    private var isPagingEnabled = true

    constructor(context: Context?) : super(context!!) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs
    )

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onTouchEvent(event)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        return isPagingEnabled && super.onInterceptTouchEvent(event)
    }

    fun setPagerEnabled(enabled: Boolean) {
        isPagingEnabled = enabled
    }
}