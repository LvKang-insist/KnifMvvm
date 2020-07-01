package com.lv.module_sort

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.standalone.core.storage.database.user.User

/**
 * @name RvAdapter
 * @package com.lv.module_sort
 * @author 345 QQ:1831712732
 * @time 2020/6/8 20:16
 * @description
 */

class RvAdapter() :
    PagedListAdapter<User, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User) = oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: User, newItem: User) = oldItem == newItem

    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sort_rv_item, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun getItemViewType(position: Int): Int {
        return 0
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val tv = holder.itemView.findViewById<AppCompatTextView>(R.id.sort_item_tv)

        tv.text = " ${getItem(position)!!.id} ${getItem(position)!!.name} -----${getItem(position)!!.age}"
    }

}