package com.lv.module_sort

import android.view.View
import android.widget.LinearLayout
import androidx.constraintlayout.solver.Cache
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.ui.frag.BaseLayoutFragment
import com.lv.library_core.utils.storage.CacheDataBase
import com.lv.library_core.utils.storage.dao.user.User
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.sort_frag.*


/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */ 

@FragmentAnno("sort-fragment")
class SortFragment : BaseLayoutFragment<SortViewModel>() {


    override fun createViewModel(): Class<SortViewModel> = SortViewModel::class.java

    override fun layout(): Int {
        return R.layout.sort_frag
    }

    override fun bindView(rootView: View) {

        val adapter = RvAdapter()
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.adapter = adapter
        viewModel.users.observe(this, Observer {
            adapter.submitList(it)
        })
//https://juejin.im/post/5db06bb6518825646d79070b#heading-23
//         recycler.setOnClickListener {
//             for (i in 0..40) {
//                 val save = CacheDataBase.get().getUser().save(User(i, "LvKang", 26))
//                 XLog.e(save)
//             }
//         }
    }


}