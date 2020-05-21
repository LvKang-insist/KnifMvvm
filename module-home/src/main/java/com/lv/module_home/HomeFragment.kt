package com.lv.module_home

import android.view.View
import com.lv.library_core.base.ui.frag.BaseBindingFragment
import com.lv.module_home.databinding.HomeFragBinding
import com.lv.module_home.test.TestActivity
import com.tencent.rtmp.TXLivePlayer
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.home_frag.*


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

        binding.home.setOnClickListener {
            startActivity(TestActivity::class.java)
        }


    }

}