package com.example.module_discover

import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.standalone.core.base.ui.frag.BaseBindingFragment
import com.example.module_discover.databinding.DiscoverFragBinding
import com.hjq.toast.ToastUtils
import com.standalone.core.utils.DataBindingConfig
import com.xiaojinzi.component.anno.FragmentAnno

/**
 * @name HomeFragment
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/12 21:51
 * @description
 */

@FragmentAnno("discover-fragment")
class DiscoverFragment : BaseBindingFragment<DiscoverFragBinding>() {

    val viewModel by viewModels<DiscoverViewModel>()


    override fun isImmersionBar(): Boolean {
        return true
    }

    override fun isDark(): Boolean {
        return false
    }

    override fun bindView() {
        viewModel.requestBean()
        viewModel.discoverLiveDataObserver.observe(this, Observer {
            binding.bean = it
        })
    }

    override fun setDataBindingConfig(): DataBindingConfig =
        DataBindingConfig(R.layout.discover_frag)
            .addParams(BR.vm, viewModel)
}