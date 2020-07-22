package com.example.module_home

import android.content.Intent
import android.graphics.Paint
import android.view.View
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_home.databinding.HomeFragBinding
import com.example.module_home.navigation.HomeContentActivity
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

    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun layout(): Int {
        return R.layout.home_frag
    }

    override fun bindView() {

        home.setOnClickListener {
            /*  //深层链接，利用 uri 直接跳转到 FragmentThree 中
               val intent = Intent(ACTION_VIEW)
              intent.data = "home://www/frag3".toUri()*/
            startActivity(Intent(context, HomeContentActivity::class.java))
        }


        request.setOnClickListener {
            viewModel.login()
        }
        viewModel.loginObserver.observe(this, Observer {
            ToastUtils.show(it)
            binding.data = it
        })
    }

}