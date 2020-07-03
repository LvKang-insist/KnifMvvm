package com.example.home

import androidx.fragment.app.Fragment
import com.example.library_core.single.BaseSingleActivity
import com.example.module_home.HomeFragment

class HomeActivity : BaseSingleActivity() {

    override fun setFragment(): Fragment {
        return HomeFragment()
    }

}
