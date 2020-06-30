package com.standalone.core.base.ui.frag

import android.view.View
import android.view.ViewGroup
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name BaseLayoutFragment
 * @package com.lv.library_core.base.ui.frag
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:52
 * @description 以普通的形式加载 fragment，拒绝使用 dataBinding
 */

abstract class BaseLayoutFragment<VM : BaseViewModel> : BaseFragment<VM>() {

    override fun initView(container: ViewGroup?): View {
        return mLayoutInflater!!.inflate(layout(), container, false)
    }

}