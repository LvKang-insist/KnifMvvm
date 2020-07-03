package com.example.discover

import androidx.fragment.app.Fragment
import com.example.library_core.single.BaseSingleActivity
import com.example.module_discover.DiscoverFragment

class DiscoverActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return DiscoverFragment()
    }
}
