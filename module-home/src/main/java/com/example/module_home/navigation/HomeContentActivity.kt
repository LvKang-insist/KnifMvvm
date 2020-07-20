package com.example.module_home.navigation


import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.hjq.toast.ToastUtils
import com.example.module_home.R
import com.example.module_home.navigation.one.FragOneViewModel
import com.gyf.immersionbar.ImmersionBar
import com.standalone.core.base.ui.activity.BaseActivity
import com.standalone.core.base.ui.activity.BaseLayoutActivity
import com.xiaojinzi.component.anno.RouterAnno
import dagger.hilt.android.AndroidEntryPoint


@RouterAnno(path = "home_navigation")
@AndroidEntryPoint
class HomeContentActivity : BaseActivity<FragOneViewModel>() {

    /*   override fun setViewModel(): Class<HomeContentViewModel> = HomeContentViewModel::class.java


       override fun layout(): Int {
           return R.layout.activity_home_content
       }
   */

    override fun setViewModel(): Class<FragOneViewModel> = FragOneViewModel::class.java


    override fun toolBarResId(): Int {
        return R.id.toolbar
    }

    override fun toolbarTitle(): String? {
        return "Navigation 导航"
    }

    override fun layout(): Int = R.layout.activity_home_content


    val model by viewModels<HomeContentViewModel>()

    override fun isImmersionBar(): Boolean {
        return false
    }

    override fun bindView() {

        ImmersionBar.with(this)
            .statusBarDarkFont(false)
            .titleBar(findViewById<View>(R.id.toolbar))
            .init()

//        model.requestBaiDu()
        model.testLiveData.observe(this, Observer {
            ToastUtils.show(it)
        })


        val navHost = NavHostFragment.create(R.navigation.home_graph)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_content, navHost) // 相等于 xml 中的 app:defaultNavHost="true"
            .setPrimaryNavigationFragment(navHost)
            .commit()
    }


}