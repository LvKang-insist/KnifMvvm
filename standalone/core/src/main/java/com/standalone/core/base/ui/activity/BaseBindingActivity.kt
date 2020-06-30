package com.standalone.core.base.ui.activity

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name BaseBindingActivity
 * @package com.lv.library_core.base.activity
 * @author 345 QQ:1831712732
 * @time 2020/5/14 22:39
 * @description BaseBindingActivity：如果需要使用 DataBinding，可以继承自此类。
 *
 */
abstract class BaseBindingActivity<V : ViewDataBinding, VM : BaseViewModel> :
    BaseSkinActivity<VM>() {

    lateinit var binding: V

    override fun initView() {

        binding = DataBindingUtil.setContentView<V>(this, layout())

        viewModel.run {
            getFinally().observe(this@BaseBindingActivity, Observer {
                Toast.makeText(this@BaseBindingActivity, it, Toast.LENGTH_LONG).show()
            })
        }
    }

    /**
     * 沉浸式状态栏的适配
     */
    open fun immersion(): Int = -1
}