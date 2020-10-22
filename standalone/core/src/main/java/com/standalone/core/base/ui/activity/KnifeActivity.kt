package com.standalone.core.base.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import com.bumptech.glide.Glide
import com.gyf.immersionbar.ImmersionBar
import com.standalone.core.R
import com.standalone.core.ui.EventMessage
import com.standalone.core.ui.bar.IBarExpand
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * @name BaseActivity
 * @class name：com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 22:52
 * @description Activity 基类
 */

abstract class KnifeActivity : AppCompatActivity(), IBarExpand {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EventBus.getDefault().register(this)
        initView()
        upDataBar()
        bindView()
        initData()
        initListener()
    }

    abstract fun initView()

    override fun ImmersionBar.expand() {
        if (toolBarResId() != View.NO_ID) {
            val view = findViewById<View>(toolBarResId())
            titleBar(view)
            if (view is ViewGroup) {
                val back = view.findViewWithTag<View>("back")
                back?.setOnClickListener { finish() }
                val title = view.findViewWithTag<AppCompatTextView>("title")
                if (title != null && TextUtils.isEmpty(title.text)) {
                    title.text = toolbarTitle()
                }
                if (isWhiteToolbar()) {
                    Glide.with(this@KnifeActivity).load(R.drawable.left_white_start)
                        .into(back as ImageView)
                    title.setTextColor(Color.WHITE)
                }
            }
        }
    }


    open fun initData() {

    }

    open fun initListener() {

    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }


    /**
     * EventBus 事件接收
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    open fun onEventMessage(event:EventMessage) = Unit


    /**
     * toolbar 默认是黑色字体，返回按钮默认黑色
     *
     * @return true 表示使用白色字体和白色返回按钮
     */
    open fun isWhiteToolbar(): Boolean = false

    /**
     * 如果使用了 layout_toolbar 布局，可重写此方法设置标题
     *
     * @return
     */
    open fun toolbarTitle(): String? = ""


    /**
     * 页面标题栏的 ID
     *
     * @return
     */
    open fun toolBarResId(): Int = View.NO_ID


    abstract fun bindView()


}