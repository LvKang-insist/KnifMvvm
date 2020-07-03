package com.standalone.core.ui

import android.content.res.Resources
import android.util.TypedValue

/**
 * dp 转像素
 */
fun dp2px(dp: Float): Float {
    return TypedValue.applyDimension(
        TypedValue.COMPLEX_UNIT_DIP,
        dp,
        Resources.getSystem().displayMetrics
    )
}