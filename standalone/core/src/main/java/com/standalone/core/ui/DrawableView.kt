package com.standalone.core.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.View

/**
 * @name DrawableView
 * @package com.standalone.core.ui
 * @author 345 QQ:1831712732
 * @time 2020/7/8 20:26
 * @description
 */
class DrawableView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    val drawable: Drawable

    init {
        drawable = MeshDrawable()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //设置 drawable 的四个边
        drawable.setBounds(0, 0, width, height)
        drawable.draw(canvas)

    }
}