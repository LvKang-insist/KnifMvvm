package com.example.discover

import androidx.fragment.app.Fragment
import com.standalone.core.single.BaseSingleActivity
import com.lv.module_discover.DiscoverFragment

class SingleActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return DiscoverFragment()
    }

}
