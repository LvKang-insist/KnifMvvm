package com.lv.sort

import androidx.fragment.app.Fragment
import com.lv.library_core.single.BaseSingleActivity
import com.lv.module_sort.SortFragment

class SortActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return SortFragment()
    }
}
