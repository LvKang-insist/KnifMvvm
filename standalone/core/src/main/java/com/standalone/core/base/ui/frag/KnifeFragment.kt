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
import com.standalone.core.ui.EventMessage
import com.standalone.core.ui.bar.IBarExpand
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

abstract class KnifeFragment : Fragment(), IBarExpand {

    private var isLazyLoad = false

    lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        rootView = initView(inflater, container)
        EventBus.getDefault().register(this)
        return rootView
    }


    abstract fun initView(inflater: LayoutInflater, container: ViewGroup?): View

    override fun onResume() {
        super.onResume()
        upDataBar()
        if (!isLazyLoad) {
            isLazyLoad = true
            bindView()
        }
    }

    /**
     * EventBus 事件接收
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onEventMessage(event: EventMessage) = Unit

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }



    override fun isImmersionBar(): Boolean = false


    /**
     * 逻辑处理
     */
    abstract fun bindView()


    /**
     * 懒加载
     */
    open fun lazyLoad() = Unit


}