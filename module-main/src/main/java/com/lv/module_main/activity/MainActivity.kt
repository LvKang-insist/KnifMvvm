package com.lv.module_main.activity

import android.graphics.Color
import androidx.fragment.app.Fragment
import com.lv.library_core.model.MainViewModel
import com.lv.module_main.R
import com.lv.module_main.activity.base.BaseMainTabItemActivity
import com.lv.module_main.activity.bottom.BottomTabBean
import com.lv.module_main.activity.bottom.ItemBuilder
import com.lv.module_main.databinding.BottomActivityBinding
import com.lv.module_main.main.Frag
import com.xiaojinzi.component.impl.Router

/**
 * @name MainActivity
 * @class name：com.lv.module_main
 * @author 345 QQ:1831712732
 * @time 2020/5/7 22:59
 * @description
 */

class MainActivity : BaseMainTabItemActivity<BottomActivityBinding, MainViewModel>() {

    override fun setItems(builder: ItemBuilder): LinkedHashMap<BottomTabBean, Fragment> {
        val home = Router.with("homeFragment").navigate()!!
        val sort = Router.with("sort-fragment").navigate()!!
        val discover = Router.with("discover-fragment").navigate()!!
        val user = Router.with("user-fragment").navigate()!!
        builder.addItem(
            BottomTabBean(R.drawable.icon_home_false, R.drawable.icon_home_true, "首页"),
            home
        )
        builder.addItem(
            BottomTabBean(R.drawable.icon_mdd_false, R.drawable.icon_mdd_true, "目的地"), sort
        )
        builder.addItem(
            BottomTabBean(R.drawable.icon_service_false, R.drawable.icon_service_true, "服务"),
            discover
        )
        builder.addItem(
            BottomTabBean(R.drawable.icon_my_false, R.drawable.icon_my_true, "我的"), user
        )
        return builder.build()
    }

    override fun setIndexPos(): Int {
        return 0
    }

    override fun setSelectColor(): Int {
        return Color.RED
    }


    override fun layout(): Int {
        return R.layout.bottom_activity
    }

    override fun setViewModel(): Class<MainViewModel> = MainViewModel::class.java

}