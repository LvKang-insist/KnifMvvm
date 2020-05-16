package com.lv.module_home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.frag.BaseFragment
import com.xiaojinzi.component.anno.FragmentAnno

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("HomeFragment")
class HomeFragment : BaseFragment() {

    override fun layout(): Int {
        return R.layout.home_frag
    }

    override fun bindView(rootView: View) {

    }

}