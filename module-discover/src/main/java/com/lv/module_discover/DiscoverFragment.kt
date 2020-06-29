package com.lv.module_discover

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.lv.library_core.base.ui.frag.BaseBindingFragment
import com.lv.module_discover.databinding.DiscoverFragBinding
import com.xiaojinzi.component.anno.FragmentAnno
import kotlinx.android.synthetic.main.discover_frag.*

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

    override fun bindView(rootView: View) {

    }


}