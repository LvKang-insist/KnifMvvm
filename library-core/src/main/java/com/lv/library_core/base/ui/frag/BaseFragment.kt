package com.lv.library_core.base.ui.frag

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lv.library_core.base.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    private var isLazyLoad = false

    lateinit var viewModel: VM

    val mLayoutInflater: LayoutInflater? by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider.NewInstanceFactory().create(setViewModel())
        lifecycle.addObserver(viewModel)
        return initView(container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindView(view)
        bindView(view, savedInstanceState)
    }


    abstract fun initView(container: ViewGroup?): View

    override fun onResume() {
        super.onResume()
        if (!isLazyLoad) {
            isLazyLoad = true
            lazyLoad()
        }
    }

    fun <T> startActivity(clazz: Class<T>) {
        context?.startActivity(Intent(context, clazz))
    }

    /**
     * 设置 ViewModel
     */
    abstract fun setViewModel(): Class<VM>

    /**
     * 加载布局
     */
    abstract fun layout(): Int

    /**
     * 逻辑处理
     */
    abstract fun bindView(rootView: View)

    open fun bindView(view: View, savedInstanceState: Bundle?) = Unit

    /**
     * 懒加载
     */
    open fun lazyLoad() = Unit


}