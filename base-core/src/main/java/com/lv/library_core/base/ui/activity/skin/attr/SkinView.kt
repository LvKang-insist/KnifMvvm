package com.lv.library_core.base.ui.activity.skin.attr

import android.view.View

class SkinView(
    private val view: View,
    private val skinAttrs: List<SkinAttr>
) {

    fun skin() {
        skinAttrs.forEach {
            it.skin(view)
        }
    }

}