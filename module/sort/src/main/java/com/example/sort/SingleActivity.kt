package com.example.sort

import androidx.fragment.app.Fragment
import com.standalone.core.single.BaseSingleActivity
import com.lv.module_sort.SortFragment

class SingleActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return SortFragment()
    }
}
