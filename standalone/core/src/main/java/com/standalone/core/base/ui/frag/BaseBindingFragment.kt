package com.standalone.core.base.ui.frag

import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name BaseBindingFragment
 * @package com.lv.library_core.base.ui.frag
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:41
 * @description Fragment 使用 DataBinding
 */

abstract class BaseBindingFragment<V : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VM>() {

    lateinit var binding: V

    override fun initView(container: ViewGroup?): View {
        val binding =
            DataBindingUtil.inflate<V>(mLayoutInflater!!, layout(), container, false)
        this.binding = binding

        viewModel.run {
            //默认实现 Toast
            getFinally().observe(this@BaseBindingFragment, Observer {
                ToastUtils.show(it)
            })
        }

        return binding.root
    }

}