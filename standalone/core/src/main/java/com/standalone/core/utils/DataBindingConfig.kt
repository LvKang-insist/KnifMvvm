package com.standalone.core.utils

import android.util.SparseArray
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable

class DataBindingConfig(@LayoutRes val layout: Int) {

    val bindParams by lazy {
        SparseArray<Any>(5)
    }


    fun addParams(variableId: Int, @Nullable value: Any): DataBindingConfig {
        bindParams.put(variableId, value)
        return this
    }

    fun removeParams(variableId: Int) {
        bindParams.remove(variableId)
    }

}