package com.example.module_home

import android.content.Intent
import android.graphics.Paint
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_home.databinding.HomeFragBinding
import com.example.module_home.navigation.HomeContentActivity
import com.example.module_home.navigation.one.FragOneViewModel
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
class HomeFragment : BaseBindingFragment<HomeFragBinding, FragOneViewModel>() {


    override fun createViewModel(): Class<FragOneViewModel>? = FragOneViewModel::class.java

    val homeViewModel by viewModels<HomeViewModel>()

    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun layout(): Int {
        return R.layout.home_frag
    }

    override fun bindView() {
        lifecycle.addObserver(homeViewModel)

        home.setOnClickListener {
            /*  //深层链接，利用 uri 直接跳转到 FragmentThree 中
               val intent = Intent(ACTION_VIEW)
              intent.data = "home://www/frag3".toUri()*/
            startActivity(Intent(context, HomeContentActivity::class.java))
        }


        request.setOnClickListener {
            homeViewModel.login()
        }
        homeViewModel.loginObserver.observe(this, Observer {
            ToastUtils.show(it)
            binding.data = it
        })
    }

}