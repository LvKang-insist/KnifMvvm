package com.lv.library_core.base.ui.activity.skin.attr

import android.view.View
import com.example.core.base.skin.attr.SkinType

class SkinAttr(private val resName: String, private val  type: SkinType) {

    fun skin(view: View) {
        type.skin(view,resName)
    }
}