package com.lv.module_discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elvishew.xlog.XLog
import com.lv.library_core.base.ui.frag.BaseBindingFragment
import com.lv.module_discover.databinding.DiscoverFragBinding
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

    override fun setViewModel(): Class<DiscoverViewModel> = DiscoverViewModel::class.java

    override fun layout(): Int {
        return R.layout.discover_frag
    }

    override fun bindView(rootView: View) {

    }

}