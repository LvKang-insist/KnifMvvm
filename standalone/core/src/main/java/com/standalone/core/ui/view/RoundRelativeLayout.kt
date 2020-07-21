package com.standalone.core.ui.view

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.standalone.core.ui.view.RoundViewHelper.Companion.setViewOutLine

/**
 * 圆角 Button
 */
class RoundRelativeLayout @JvmOverloads constructor(
    context: Context?,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {
    fun setViewOutLine(radius: Int, radiusSize: Int) {
        setViewOutLine(this, radius, radiusSize)
    }

    init {
        setViewOutLine(this, attrs, defStyleAttr, 0)
    }
}