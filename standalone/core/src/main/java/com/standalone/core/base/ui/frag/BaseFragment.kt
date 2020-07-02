package com.standalone.core.base.ui.frag

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.hjq.toast.ToastUtils
import com.standalone.core.base.viewmodel.BaseViewModel
import com.permissionx.guolindev.PermissionX
import java.lang.NullPointerException

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    private var isLazyLoad = false

    lateinit var viewModel: VM

    val mLayoutInflater: LayoutInflater? by lazy {
        LayoutInflater.from(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        viewModel = setViewModel()
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

    fun permission(block: () -> Unit, permission: String) {
        PermissionX.init(requireActivity())
            .permissions(permission)
            .request { allGranted, _, _ ->
                if (allGranted) {
                    block()
                } else {
                    ToastUtils.show("权限获取失败")
                }
            }
    }

    private fun setViewModel(): VM {
        val viewModel = createViewModel()
        return if (viewModel != null) {
            ViewModelProvider(this).get(viewModel)
        } else {
            val stateViewModel =
                createStateViewModel() ?: throw NullPointerException("$this ---> ViewModel 为 null")
            ViewModelProvider(
                this,
                SavedStateViewModelFactory(activity!!.application, this)
            ).get(stateViewModel)
        }
    }

    /**
     * 设置 ViewModel
     */
    open fun createViewModel(): Class<VM>? = null

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
    abstract fun bindView(rootView: View)

    open fun bindView(view: View, savedInstanceState: Bundle?) = Unit

    /**
     * 懒加载
     */
    open fun lazyLoad() = Unit


}