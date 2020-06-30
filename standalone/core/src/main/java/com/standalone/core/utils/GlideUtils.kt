package com.standalone.core.utils

import android.graphics.drawable.Drawable
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

/**
 * @name GlideUtils
 * @package com.lv.library_core.utils
 * @author 345 QQ:1831712732
 * @time 2020/5/11 20:33
 * @description
 */
object GlideUtils {


    /**
     * 设置 image
     */
    fun load(imageView: AppCompatImageView, resId: Int) {
        Glide.with(imageView.context)
            .load(resId)
            .into(imageView)
    }

    /**
     * 设置 image
     */
    fun load(imageView: AppCompatImageView, url: String) {
        Glide.with(imageView.context)
            .load(url)
            .into(imageView)
    }



    /**
     * 给 View 设置背景
     */
    fun setBackGround(view: View, resId: Int) {
        Glide.with(view.context)
            .asDrawable()
            .load(resId)
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    view.background = resource
                }
            })
    }

    /**
     * 给 View 设置背景
     */
    fun setBackGround(view: View, url: String) {
        Glide.with(view.context)
            .asDrawable()
            .load(url)
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: Transition<in Drawable>?
                ) {
                    view.background = resource
                }
            })
    }
}