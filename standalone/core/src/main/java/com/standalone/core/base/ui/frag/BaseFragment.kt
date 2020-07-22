package com.standalone.core.base.ui.frag

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gyf.immersionbar.ImmersionBar
import com.standalone.core.R
import com.standalone.core.base.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    private var isLazyLoad = false

    lateinit var viewModel: VM

    lateinit var rootView: View

    val mLayoutInflater: LayoutInflater by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewModel = setViewModel()
        lifecycle.addObserver(viewModel)
        rootView = initView(container)
        return rootView
    }


    abstract fun initView(container: ViewGroup?): View

    override fun onResume() {
        super.onResume()
        initBar()
        if (!isLazyLoad) {
            isLazyLoad = true
            bindView()
        }
    }


    fun <T> startActivity(clazz: Class<T>) {
        context?.startActivity(Intent(context, clazz))
    }


    private fun setViewModel(): VM {
        val viewModel = createViewModel()
        return if (viewModel != null) {
            ViewModelProvider(this).get(viewModel)
        } else {
            val stateViewModel = createStateViewModel()
                ?: throw NullPointerException("$this ---> ViewModel 为 null")
            ViewModelProvider(
                this, SavedStateViewModelFactory(requireActivity().application, this)
            ).get(stateViewModel)
        }
    }

    open fun initBar() {
        if (isImmersionBar()) {
            val view = rootView.findViewById<View>(titleBarResId())
            initBar(isDark(), view)
        }
    }

    open fun initBar(isDark: Boolean, view: View?) {
        ImmersionBar
            .with(this)
            .statusBarDarkFont(isDark)
            .titleBar(view)
            .init()
    }

    /**
     * 是否开启沉浸式状态栏，默认为 false
     * 注意，开启后 Activity 中设置的沉浸式将会失效
     */
    open fun isImmersionBar(): Boolean = false


    /**
     * 设置 fragment 中状态栏的颜色,默认为 true
     * 注意：如果要在 fragment 中设置状态栏的颜色，则需要在对应的 Activity 中重写 isImmersionBar 方法
     *      并返回 false，否则无法生效
     */
    open fun isDark(): Boolean = true

    /**
     * toolbar id
     */
    open fun titleBarResId(): Int {
        return View.NO_ID
    }

    /**
     * 设置 ViewModel此，
     * 方法默认必须实现，结果可为 null
     * 为 null 时则调用下面的方法
     */
    abstract fun createViewModel(): Class<VM>?

    /**
     * 带数据恢复的 ViewModel，可通过 savedStateHandler 进行设置
     */
    open fun createStateViewModel(): Class<VM>? = null

    /**
     * 加载布局
     */
    abstract fun layout(): Int

    /**
     * 逻辑处理
     */
    abstract fun bindView()


    /**
     * 懒加载
     */
    open fun lazyLoad() = Unit


}