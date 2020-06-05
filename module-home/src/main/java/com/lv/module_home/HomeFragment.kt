package com.lv.module_home

import android.content.Intent
import android.view.View
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
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


    override fun createViewModel(): Class<HomeViewModel>? = HomeViewModel::class.java

    override fun layout(): Int {
        return R.layout.home_frag
    }


    override fun bindView(rootView: View) {
        home.setOnClickListener {
            startActivity(Intent(context, TestActivity::class.java))
        }

        request.setOnClickListener {
            viewModel.login()
        }
        viewModel.loginLiveData.observe(this, Observer {
            ToastUtils.show(it.value)
        })
    }

}