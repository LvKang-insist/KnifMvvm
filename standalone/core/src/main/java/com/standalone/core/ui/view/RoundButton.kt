package com.standalone.core.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatButton
import com.standalone.core.ui.view.RoundViewHelper.Companion.setViewOutLine

/**
 * 圆角 Button
 */
class RoundButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : AppCompatButton(context, attrs, defStyleAttr) {
    fun setViewOutLine(radius: Int, radiusSize: Int) {
        setViewOutLine(this, radius, radiusSize)
    }

    init {
        setViewOutLine(this, attrs, defStyleAttr, 0)
    }
}