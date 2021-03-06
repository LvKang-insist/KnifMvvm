package com.standalone.main.bottom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

/**
 * @name MainContentAdapter
 * @package com.lv.module_main.activity.bottom
 * @author 345 QQ:1831712732
 * @time 2020/5/11 21:24
 * @description 主界面内容区域适配器
 */

class MainContentAdapter(
    fragmentActivity: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: List<Fragment>
) : FragmentStateAdapter(fragmentActivity, lifecycle) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}
//class MainContentAdapter(
//    fragmentManager: FragmentManager,
//    behavior: Int,
//    private val fragments: List<Fragment>
//) :
//    FragmentStatePagerAdapter(fragmentManager, behavior) {
//
//    override fun getItem(position: Int): Fragment {
//        return fragments[position]
//    }
//
//    override fun getCount(): Int {
//        return fragments.size
//    }
//
//}