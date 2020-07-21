package com.standalone.core.ui.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.standalone.core.R

/**
 * 自定义 edit，可设置图片大小等
 */
class EditViewImage : AppCompatEditText {
    private var mStartWidth = 0
    private var mStartHeight = 0
    private var mTopWidth = 0
    private var mTopHeight = 0
    private var mEndWidth = 0
    private var mEndHeight = 0
    private var mBottomWidth = 0
    private var mBottomHeight = 0

    constructor(context: Context?) : super(context) {}
    constructor(context: Context, attrs: AttributeSet) : super(
        context,
        attrs
    ) {
        init(context, attrs)
    }

    constructor(
        context: Context,
        attrs: AttributeSet,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    private fun init(
        context: Context,
        attrs: AttributeSet
    ) {
        @SuppressLint("CustomViewStyleable") val typedArray =
            context.obtainStyledAttributes(attrs, R.styleable.DrawableImage)
        mStartWidth =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableStartWidth, 0)
        mStartHeight =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableStartHeight, 0)
        mTopWidth =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableTopWidth, 0)
        mTopHeight =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableTopHeight, 0)
        mEndWidth =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableEndWidth, 0)
        mEndHeight =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableEndHeight, 0)
        mBottomWidth =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableBottomWidth, 0)
        mBottomHeight =
            typedArray.getDimensionPixelOffset(R.styleable.DrawableImage_drawableBottomHeight, 0)
        typedArray.recycle()
        setDrawablesSize()
    }

    private fun setDrawablesSize() {
        val compoundDrawables = compoundDrawablesRelative
        for (i in compoundDrawables.indices) {
            when (i) {
                0 -> {
                    setDrawableBounds(compoundDrawables[0], mStartWidth, mStartHeight)
                    setDrawableBounds(compoundDrawables[1], mTopWidth, mTopHeight)
                }
                1 -> setDrawableBounds(compoundDrawables[1], mTopWidth, mTopHeight)
                2 -> setDrawableBounds(compoundDrawables[2], mEndWidth, mEndHeight)
                3 -> setDrawableBounds(compoundDrawables[3], mBottomWidth, mBottomHeight)
                else -> {
                }
            }
        }
        setCompoundDrawablesRelative(
            compoundDrawables[0], compoundDrawables[1],
            compoundDrawables[2], compoundDrawables[3]
        )
    }

    private fun setDrawableBounds(drawable: Drawable?, width: Int, height: Int) {
        if (drawable != null) {
            drawable.setBounds(0, 0, width, height)
            if (width == 0 || height == 0) {
                val scale =
                    drawable.intrinsicHeight / drawable.intrinsicWidth.toDouble()
                val bounds = drawable.bounds
                //高宽只给一个值时，自适应
                if (width == 0 && height != 0) {
                    bounds.right = (bounds.bottom / scale).toInt()
                    drawable.bounds = bounds
                }
                if (width != 0) {
                    bounds.bottom = (bounds.right * scale).toInt()
                    drawable.bounds = bounds
                }
            }
        }
    }
}