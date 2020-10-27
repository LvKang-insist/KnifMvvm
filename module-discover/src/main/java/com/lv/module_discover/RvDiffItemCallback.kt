package com.lv.module_discover

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

class RvDiffItemCallback(val old: List<String>, val new: List<String>) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return old.size
    }

    override fun getNewListSize(): Int {
        return new.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {

        return old[oldItemPosition] == new[newItemPosition]
    }


    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return old[oldItemPosition] != new[newItemPosition]
    }

    //
    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val payload = Bundle()
        payload.putString("key", "${old[oldItemPosition]} = ${new[newItemPosition]} 重复的值")
        return payload
    }
}