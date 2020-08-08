package com.standalone.core.ui.drag

import android.content.Context
import android.util.AttributeSet
import android.view.DragEvent
import android.view.View
import android.view.ViewConfiguration
import android.view.ViewGroup

/**
 * 拖拽
 */
class DragListenerGridView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {


    private val columns = 2
    private val rows = 3


    val viewConfiguration: ViewConfiguration = ViewConfiguration.get(getContext())

    val dragListener = HenDragListener()

    lateinit var draggedView: View

    val orderedChildren = mutableListOf<View>()


    init {
        isChildrenDrawingOrderEnabled = true
    }

    override fun onDragEvent(event: DragEvent?): Boolean {
        return super.onDragEvent(event)
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        for (i in 0 until childCount) {
            val child = getChildAt(i)
            orderedChildren.add(child)
            //长按监听
            child.setOnLongClickListener {
                draggedView = it
                //开始拖拽
                it.startDrag(null, DragShadowBuilder(it), it, 0)
                false
            }
            //响应拖拽之后的操作
            child.setOnDragListener(dragListener)
        }
    }

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
            view.layout(0, 0, childWidth, childHeight)
            view.translationX = childLeft.toFloat()
            view.translationY = childTop.toFloat()
        }
    }


    inner class HenDragListener : OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    if (event.localState == v) {
                        //拖拽的开始
                        v.visibility = View.INVISIBLE
                    }
                }
                DragEvent.ACTION_DRAG_ENTERED -> {
                    //手指触摸到了某个View的区域内
                    if (event.localState != v) {
                        //如果不是拖动的 View，则不需要排序
                        sort(v)
                    }
                }
                DragEvent.ACTION_DRAG_EXITED -> {

                }
                DragEvent.ACTION_DRAG_ENDED -> {
                    v.visibility = View.VISIBLE
                }
            }
            return true
        }


    }

    private fun sort(trgetView: View) {
        var draggedIndex = -1
        var targetIndex = -1
        for (i in 0 until childCount) {
            val child = orderedChildren[i]
            if (trgetView == child) {
                targetIndex = 1;
            } else if (draggedView == child) {
                draggedIndex = i
            }
        }
        if (targetIndex < draggedIndex) {
            orderedChildren.removeAt(draggedIndex)
            orderedChildren.add(targetIndex, draggedView)
        } else if (targetIndex > draggedIndex) {
            orderedChildren.removeAt(draggedIndex)
            orderedChildren.add(targetIndex, draggedView)
        }
        var childLeft: Int
        var childTop: Int
        val childWidth = width / columns
        val childHeight = height / rows
        for (i in 0 until childCount) {
            val child = orderedChildren.get(i)
            childLeft = i % 2 * childWidth
            childTop = i / 2 * childHeight
            child.animate()
                .translationX(childLeft.toFloat())
                .translationY(childTop.toFloat())
                .setDuration(150)
        }
    }
}