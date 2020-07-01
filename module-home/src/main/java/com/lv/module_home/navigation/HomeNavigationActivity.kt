package com.lv.module_home.navigation


import android.net.Uri
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.lv.module_home.R
import com.standalone.core.base.ui.activity.BaseLayoutActivity
import com.xiaojinzi.component.anno.RouterAnno
import com.xiaojinzi.component.anno.router.RouterApiAnno
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.home_navigation.*


@RouterAnno(path = "home_navigation")
@AndroidEntryPoint
class HomeNavigationActivity : BaseLayoutActivity<TestViewModel>() {

    override fun setViewModel(): Class<TestViewModel> = TestViewModel::class.java


    override fun layout(): Int {
        return R.layout.home_navigation
    }

    override fun bindView() {
        val navHost = NavHostFragment.create(R.navigation.home_graph)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.home_content, navHost) // 相等于 xml 中的 app:defaultNavHost="true"
            .setPrimaryNavigationFragment(navHost)
            .commit()

//        findNavController(R.id.home_content).navigate(Uri.parse("home/frag3"))
    }

}