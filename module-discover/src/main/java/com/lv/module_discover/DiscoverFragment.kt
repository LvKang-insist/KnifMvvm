package com.lv.module_discover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elvishew.xlog.XLog
import com.xiaojinzi.component.anno.FragmentAnno

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("discover-fragment")
class DiscoverFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.discover_frag, container, false)
    }

}