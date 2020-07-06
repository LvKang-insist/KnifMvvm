package com.standalone.core.ui

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.TypedValue
import com.standalone.core.R

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

fun getAvatar(resources: Resources, width: Int): Bitmap {
    val options = BitmapFactory.Options()
    //设置 true，就只会取到宽高
    options.inJustDecodeBounds = true
    //拿到宽高
    BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
    //使用宽高，重新获取图片，对性能有一定好处
    options.inJustDecodeBounds = false
    options.inDensity = options.outWidth
    options.inTargetDensity = width
    return BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
}