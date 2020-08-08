package com.standalone.core.ui.drag

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.customview.widget.ViewDragHelper

class DragHelperGridView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {


    private val columns = 2
    private val rows = 3



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)
        val specHeight = MeasureSpec.getSize(heightMeasureSpec)
        val childWidth = specWidth / columns
        val childHeight = specHeight / rows

        //测量子布局
        measureChildren(
            MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.EXACTLY),
            MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.EXACTLY)
        )
        setMeasuredDimension(specWidth, childHeight)
    }

    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        var childLeft: Int
        var childTop: Int
        val childWidth = width / columns
        val childHeight = height / rows
        for (i in 0 until count) {
            val view = getChildAt(i)
            childLeft = i % 2 * childWidth
            childTop = i / 2 * childHeight
            view.layout(
                childLeft, childTop, childLeft + childWidth,
                childTop + childHeight
            )
        }
    }

    class DragCallback : ViewDragHelper.Callback() {
        override fun tryCaptureView(child: View, pointerId: Int): Boolean {
            return true
        }

        override fun clampViewPositionHorizontal(child: View, left: Int, dx: Int): Int {
            return left
        }

        override fun clampViewPositionVertical(child: View, top: Int, dy: Int): Int {
            return top
        }

    }
}