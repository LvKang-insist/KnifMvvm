package com.lv.module_home.navigation.two

import androidx.fragment.app.viewModels
import com.lv.module_home.R
import com.standalone.core.base.ui.frag.KnifeLayoutFragment


class FragmentTwo : KnifeLayoutFragment() {


    val vm by viewModels<FragTwoViewModel>()


    override fun isImmersionBar(): Boolean {
        return true
    }


    override fun layout(): Int {
        return R.layout.frag_two
    }

    override fun bindView() {

        val adapter = RvAdapter()

    }

}