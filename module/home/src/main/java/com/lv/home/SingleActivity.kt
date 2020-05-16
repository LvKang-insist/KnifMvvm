package com.lv.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.lv.library_core.base.single.BaseSingleActivity
import com.lv.module_home.HomeFragment

class SingleActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return HomeFragment()
    }

}
