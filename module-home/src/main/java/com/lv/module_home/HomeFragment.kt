package com.lv.module_home


import android.view.View
import androidx.lifecycle.Observer
import com.elvishew.xlog.XLog
import com.lv.library_core.base.ui.frag.BaseBindingFragment
import com.lv.module_home.databinding.HomeFragBinding
import com.lv.module_home.test.TestActivity
import com.xiaojinzi.component.anno.FragmentAnno

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("HomeFragment")
class HomeFragment : BaseBindingFragment<HomeFragBinding, HomeViewModel>() {

    override fun setViewModel(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun layout(): Int {
        return R.layout.home_frag
    }

    override fun bindView(rootView: View) {

        val map = mutableMapOf<String, String>()
        XLog.e(map.isNotEmpty())
        map.put("111", "222")
        XLog.e(map.isNotEmpty())

        binding.request.setOnClickListener {
            viewModel
                .getDefaultRequest("https://www.baidu.com")
                .observe(this, Observer {
                    binding.data = it
                })
        }

        binding.home.setOnClickListener {
            startActivity(TestActivity::class.java)
        }
    }

}