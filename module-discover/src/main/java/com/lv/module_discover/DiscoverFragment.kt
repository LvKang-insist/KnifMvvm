package com.lv.module_discover

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.*
import com.standalone.core.base.ui.frag.KnifeBindingFragment
import com.lv.module_discover.databinding.DiscoverFragBinding
import com.standalone.core.utils.DataBindingConfig
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.discover_frag.*

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("discover-fragment")
class DiscoverFragment : KnifeBindingFragment<DiscoverFragBinding>() {

    val viewModel by viewModels<DiscoverViewModel>()

    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun isBarDark(): Boolean = true

    override fun bindView() {
        val adapter = Adapter()

        val list = arrayListOf<String>()
        list.add("1")
        list.add("2")
        list.add("3")
        list.add("4")
        list.add("5")
        list.add("6")
        list.add("7")
        list.add("8")
        list.add("11")

        val list2 = arrayListOf<String>()

        list2.add("1")
        list2.add("6")
        list2.add("8")
        list2.add("9")
        list2.add("10")

        viewModel.requestBean()
        viewModel.discoverLiveDataObserver.observe(this, Observer {
            binding.bean = it
        })
        binding.tv.setOnClickListener {
            adapter.addNewData(list2)
        }

        viewModel.discover.observe(this, Observer {

        })


        binding.recycler.layoutManager = LinearLayoutManager(requireContext())
        binding.recycler.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.recycler.adapter = adapter
        adapter.addNewData(list)
    }

    override fun setDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(R.layout.discover_frag)
            .addParams(BR.vm, viewModel)


    class Adapter() : RecyclerView.Adapter<Adapter.Holder>() {
        var data = mutableListOf<String>()

        fun addNewData(list: MutableList<String>) {
            val diffResult = DiffUtil.calculateDiff(RvDiffItemCallback(data, list), false)
            data = list
//            diffResult.dispatchUpdatesTo(this)
            diffResult.dispatchUpdatesTo(object : ListUpdateCallback {
                override fun onChanged(position: Int, count: Int, payload: Any?) {
                    notifyItemRangeChanged(position, count, payload)
                }

                override fun onMoved(fromPosition: Int, toPosition: Int) {
                    notifyItemMoved(fromPosition, toPosition)
                }

                override fun onInserted(position: Int, count: Int) {
                    notifyItemRangeInserted(position, count)

                }

                override fun onRemoved(position: Int, count: Int) {
                    notifyItemRangeRemoved(position, count)
                }

            })
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
            return Holder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
            )
        }

        override fun getItemCount(): Int = data.size


        override fun onBindViewHolder(holder: Holder, position: Int, payloads: MutableList<Any>) {
            if (payloads.isEmpty()) {
                onBindViewHolder(holder, position)
            } else {
                //增量更新
                val pay = payloads[0] as Bundle
                val value = pay.get("key") as String
                holder.tvText.text = value
            }
        }

        override fun onBindViewHolder(holder: Holder, position: Int) {
            holder.tvText.text = data[position]
        }

        class Holder(view: View) : RecyclerView.ViewHolder(view) {
            val tvText = view as AppCompatTextView
        }
    }
}