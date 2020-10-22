package com.lv.discover

import androidx.fragment.app.Fragment
import com.lv.library_core.single.BaseSingleActivity
import com.lv.module_discover.DiscoverFragment

class DiscoverActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return DiscoverFragment()
    }
}
