package com.standalone.core.ui

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.standalone.core.R
import java.util.function.BiFunction

class AvatarView : View {

    val paint = Paint()

    val padding = dp2px(50f)

    val xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)

    val saveYser = RectF()

    var bitmap: Bitmap? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    {
        bitmap = getAvatar(dp2px(300f).toInt())
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        saveYser.set(padding, padding, padding + width, padding + width)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //抠出一个 方块
        val saved = canvas.saveLayer(saveYser, paint)
        //在抠出的方块中画圆
        canvas.drawOval(padding, padding, padding + width, padding + width, paint)
        //保留覆盖的图，丢弃剩余的图
        paint.setXfermode(xfermode)
        //画个方形图片，结果就是保留这个圆，并且丢弃没有覆盖的地方
        canvas.drawBitmap(bitmap!!, padding, padding, paint)

        //恢复 xfermode，保证后面绘制不会有问题
        paint.setXfermode(null)
        // 将扣出来的方法放回去
        canvas.restoreToCount(saved)
    }


    fun getAvatar(width: Int): Bitmap {
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
}