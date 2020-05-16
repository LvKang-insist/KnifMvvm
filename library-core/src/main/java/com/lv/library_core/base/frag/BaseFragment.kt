package com.lv.library_core.base.frag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.elvishew.xlog.XLog
import com.hjq.toast.ToastUtils

abstract class BaseFragment : Fragment() {

    private var isLazyLoad = false


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        bindView(view)
    }

    override fun onResume() {
        super.onResume()
        if (!isLazyLoad) {
            isLazyLoad = true
            lazyLoad()
        }
    }

    /**
     * 加载布局
     */
    abstract fun layout(): Int

    /**
     * 逻辑处理
     */
    abstract fun bindView(rootView: View)

    /**
     * 懒加载
     */
    open fun lazyLoad() = Unit

}