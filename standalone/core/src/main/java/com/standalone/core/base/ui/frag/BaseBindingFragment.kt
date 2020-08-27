package com.standalone.core.base.ui.frag

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.hjq.toast.ToastUtils
import com.standalone.core.base.viewmodel.BaseViewModel
import com.standalone.core.utils.DataBindingConfig

/**
 * @name BaseBindingFragment
 * @package com.lv.library_core.base.ui.frag
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:41
 * @description Fragment 使用 DataBinding
 */

abstract class BaseBindingFragment<V : ViewDataBinding> : BaseFragment() {

    lateinit var binding: V


    abstract fun setDataBindingConfig(): DataBindingConfig

    override fun initView(inflater: LayoutInflater, container: ViewGroup?): View {

        val dataBindingConfig = setDataBindingConfig()
        binding =
            DataBindingUtil.inflate(inflater, dataBindingConfig.layout, container, false)

        dataBindingConfig.bindParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
        return binding.root
    }

}