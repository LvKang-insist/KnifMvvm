package com.example.module_discover

import android.view.View
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_discover.databinding.DiscoverFragBinding
import com.xiaojinzi.component.anno.FragmentAnno

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("discover-fragment")
class DiscoverFragment : BaseBindingFragment<DiscoverFragBinding, DiscoverViewModel>() {

    override fun createViewModel(): Class<DiscoverViewModel> = DiscoverViewModel::class.java

    override fun layout(): Int {
        return R.layout.discover_frag
    }

    override fun bindView() {

    }


}