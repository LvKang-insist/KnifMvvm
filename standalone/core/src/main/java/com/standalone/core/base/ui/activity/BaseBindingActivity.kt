package com.standalone.core.base.ui.activity

import android.widget.Toast
import androidx.core.util.forEach
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.standalone.core.base.viewmodel.BaseViewModel
import com.standalone.core.utils.DataBindingConfig

/**
 * @name BaseBindingActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 22:39
 * @description BaseBindingActivity：如果需要使用 DataBinding，可以继承自此类。
 *
 */
abstract class BaseBindingActivity<V : ViewDataBinding> :
    BaseSkinActivity() {

    lateinit var binding: V

    override fun initView() {
        val dataBindingConfig = setDataBindingConfig()
        binding = DataBindingUtil.setContentView(this, dataBindingConfig.layout)
        dataBindingConfig.bindParams.forEach { key, value ->
            binding.setVariable(key, value)
        }
    }

    abstract fun setDataBindingConfig(): DataBindingConfig


}