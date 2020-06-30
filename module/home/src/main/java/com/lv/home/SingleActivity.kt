package com.lv.home

import androidx.fragment.app.Fragment
import com.standalone.core.single.BaseSingleActivity
import com.lv.module_home.HomeFragment

class SingleActivity : BaseSingleActivity() {

    override fun setFragment(): Fragment {
        return HomeFragment()
    }

}
