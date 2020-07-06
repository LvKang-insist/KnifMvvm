package com.standalone.core.ui

import android.content.Context
import android.graphics.*
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.elvishew.xlog.XLog
import com.standalone.core.R
import java.lang.reflect.Type

/**
 * 绘制多行文本
 */
class LinsTextView : View {


    val text = "Hilt 是 Android 的依赖注入库，是基于 Dagger 。可以说 Hilt 是专门为 Andorid 打造的。" +
            "Hilt 创建了一组标准的 组件和作用域。这些组件会自动集成到 Android 程序中的生命周期中。在使用的时候可以指定使用的范围，事情作用在对应的生命周期当中。" +
            "版权声明：本文为CSDN博主「345丶」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。" +
            "原文链接：https://blog.csdn.net/baidu_40389775/article/details/107095700"

    val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    var bitmap: Bitmap

    val cutWith = floatArrayOf()

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)


    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    init {
        paint.textSize = dp2px(15f)
        bitmap = getAvatar(dp2px(100f))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawBitmap(bitmap, width - dp2px(100f), 100f, paint)

        /**
         * 2，是否正向绘制
         * 3，View 的宽度
         * 4，拿到截取的宽度
         * return 第一行的位置
         */
        var index = paint.breakText(text, true, width.toFloat(), cutWith)
        //绘制第一行
        canvas.drawText(text, 0, index, 0f, 50f, paint)
        //绘制第二行
        var oldIndex = index
        index = paint.breakText(
            text, index, text.length, true,
            (width - bitmap.width).toFloat(), cutWith
        )
        canvas.drawText(text, oldIndex, oldIndex + index, 0f, (50 + paint.fontSpacing), paint)

        //绘制第三行
        oldIndex = index
        index = paint.breakText(
            text, oldIndex, text.length, true,
            (width - bitmap.width).toFloat(), cutWith
        )
        canvas.drawText(text, oldIndex, oldIndex + index, 0f, (50 + (paint.fontSpacing * 2)), paint)

    }


    fun getAvatar(width: Float): Bitmap {
        val options = BitmapFactory.Options()
        //设置 true，就只会取到宽高
        options.inJustDecodeBounds = true
        //拿到宽高
        BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
        //使用宽高，重新获取图片，对性能有一定好处
        options.inJustDecodeBounds = false
        options.inDensity = options.outWidth
        options.inTargetDensity = width.toInt()
        return BitmapFactory.decodeResource(resources, R.drawable.avatar, options)
    }
}