package com.standalone.core.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.standalone.core.R
import okhttp3.internal.cacheGet

/**
 * 裁切
 */
class CustomView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    val paint = Paint()

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        //绘制一个 bitmap，只会显示出 裁切的部分*/
        val bitmap = getAvatar(resources, 200)

        canvas.translate(100f, 200f)

        canvas.rotate(45f, (bitmap.width / 2).toFloat(), (bitmap.height / 2).toFloat())




        canvas.drawBitmap(bitmap, 0f, 0f, paint)

    }

}