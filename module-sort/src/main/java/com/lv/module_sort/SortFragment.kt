package com.lv.module_sort

import android.content.Intent
import android.content.Intent.ACTION_VIEW
import android.view.View
import androidx.core.net.toUri
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseLayoutFragment
import com.xiaojinzi.component.anno.FragmentAnno
import com.xiaojinzi.component.impl.Callback
import com.xiaojinzi.component.impl.Router
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

        /*   val adapter = RvAdapter()
           recycler.layoutManager = LinearLayoutManager(context)
           recycler.adapter = adapter
           viewModel.users.observe(this, Observer {
               adapter.submitList(it)
           })*/

        recycler.setOnClickListener {
            //深层链接，利用 uri 直接跳转到 FragmentThree 中
            val intent = Intent(ACTION_VIEW)
            intent.data = "home://www/frag3".toUri()

            startActivity(intent)

        }


//https://juejin.im/post/5db06bb6518825646d79070b#heading-23
//         recycler.setOnClickListener {
//             for (i in 0..40) {
//                 val save = CacheDataBase.get().getUser().save(User(i, "LvKang", 26))
//                 XLog.e(save)
//             }
//         }
    }


}