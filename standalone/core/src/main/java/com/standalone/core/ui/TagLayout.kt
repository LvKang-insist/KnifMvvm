package com.standalone.core.ui

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.ViewGroup

class TagLayout(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {


    private var childrenBounds = mutableListOf<Rect?>()

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        //使用的宽度
        var widthUsed = 0
        //行使用了的宽度
        var lineWidthUsed = 0

        //使用了的高度
        var heightUsed = 0
        //行中最大的高度
        var lineMaxHeight = 0

        val specMode = MeasureSpec.getMode(widthMeasureSpec)
        val specWidth = MeasureSpec.getSize(widthMeasureSpec)

        val count = childCount
        for (i in 0 until count) {
            val child = getChildAt(i)
            //测量子 View ,widthUser/heightUser ：使用了的高度/宽度
            //测量子 View 时候传入 widthUsed 为 0 是为了告诉子 View 当前行的宽度没有被使用，
            //这样 view 的宽度就会正常测量
            measureChildWithMargins(
                child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed
            )
            //当前行的宽度 + 子 View 的宽度 > viewGroup 的宽度，需要换行并重新测量 子View
            if (specMode != MeasureSpec.UNSPECIFIED &&
                lineWidthUsed + child.measuredWidth > specWidth
            ) {
                //重置行宽度 0
                lineWidthUsed = 0
                //换行，设置新的高度
                heightUsed += lineMaxHeight
                //行高度重置 0
                lineMaxHeight = 0
                measureChildWithMargins(
                    child, widthMeasureSpec, 0, heightMeasureSpec, heightUsed
                )
            }
            if (childrenBounds.size <= i) {
                childrenBounds.add(Rect())
            }
            val childBound = childrenBounds[i]!!
            //获取子 View 的位置并保存
            childBound.set(
                lineWidthUsed,
                heightUsed,
                lineWidthUsed + child.measuredWidth,
                heightUsed + child.measuredHeight
            )
            //保存已经使用的宽度
            lineWidthUsed += child.measuredWidth
            //拿到最大使用了的宽度
            widthUsed = Math.max(widthUsed, lineWidthUsed)
            //计算 max 高度
            lineMaxHeight = Math.max(lineMaxHeight, child.measuredHeight)
        }
        //计算当前 group 的宽高
        val width = widthUsed
        val height = heightUsed + lineMaxHeight
        setMeasuredDimension(width, height)
    }


    override fun onLayout(changed: Boolean, l: Int, t: Int, r: Int, b: Int) {
        val count = childCount
        //根据测量时设置的位置进行布局
        for (i in 0 until count) {
            val child = getChildAt(i)
            val childBounds = childrenBounds[i]!!
            child.layout(childBounds.left, childBounds.top, childBounds.right, childBounds.bottom)
        }
    }

    override fun generateLayoutParams(attrs: AttributeSet?): LayoutParams {
        return MarginLayoutParams(context, attrs)
    }
}