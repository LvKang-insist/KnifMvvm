package com.example.sort

import androidx.fragment.app.Fragment
import com.example.library_core.single.BaseSingleActivity
import com.example.module_sort.SortFragment

class SortActivity : BaseSingleActivity() {
    override fun setFragment(): Fragment {
        return SortFragment()
    }
}
