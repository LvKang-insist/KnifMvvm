package com.lv.module_home.navigation


import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.lv.library_core.base.BaseBindingActivity
import com.lv.module_home.R
import com.lv.module_home.TestActivity
import com.lv.module_home.databinding.ActivityHomeContentBinding
import com.hjq.toast.ToastUtils

import com.standalone.core.utils.DataBindingConfig
import kotlinx.android.synthetic.main.activity_home_content.*


class HomeContentActivity : BaseBindingActivity<ActivityHomeContentBinding>() {


    override fun setDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(R.layout.activity_home_content)

    val viewModel by viewModels<HomeContentViewModel>()


    override fun toolBarResId(): Int = R.id.toolbar


    override fun toolbarTitle(): String? {
        return "Activity"
    }


    override fun bindView() {

        toolbar.setOnClickListener {
            startActivity(Intent(this, TestActivity::class.java))
        }


        isImmersionBar()

        viewModel.saveCurrentValue("345", "销毁前的数据")
//
        viewModel.getSaveStateLiveData<String>("345").observe(this, Observer {
            ToastUtils.show(it)
        })


        /*val navHost = NavHostFragment.create(R.navigation.home_graph)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_content, navHost) // 相等于 xml 中的 app:defaultNavHost="true"
            .setPrimaryNavigationFragment(navHost)
            .commit()*/
    }


}