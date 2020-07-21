package com.standalone.core.ui.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import de.hdodenhof.circleimageview.CircleImageView

/**
 * @author 345 QQ:1831712732
 * @name ImageViewText
 * @class name：com.standalone.core.ui.view
 * @time 2019/12/11 23:25
 * @description 在图片的中心绘制文字
 */
class ImageViewText : CircleImageView {
    private var mText = ""
    private var mTextSize = 30
    private var mPaint: Paint = Paint()
    private var mBound: Rect = Rect()

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context, attrs, defStyle
    )

   init{
       mPaint.textSize = mTextSize.toFloat()
        mPaint.strokeWidth = 15f
        mBound = Rect()
        //设置文字的 矩阵
        mPaint.getTextBounds(mText, 0, mText.length, mBound)
    }

    fun setText(text: String) {
        mText = text
        if (mText.length > 0) {
            mPaint.getTextBounds(mText, 0, mText.length, mBound)
            invalidate()
        }
    }

    fun setTextSize(size: Int) {
        mTextSize = size
        mPaint.getTextBounds(mText, 0, mText.length, mBound)
        invalidate()
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        mPaint.color = Color.WHITE
        //绘制 文字
        canvas.drawText(
            mText, width / 2f - (mBound.left + mBound.right) / 2f,
            height / 2f - (mBound.top + mBound.bottom) / 2f, mPaint
        )
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private fun dip2px(dpValue: Float): Int {
        val scale = resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}