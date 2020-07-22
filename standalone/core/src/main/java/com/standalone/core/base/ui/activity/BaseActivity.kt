package com.standalone.core.base.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.gyf.immersionbar.ImmersionBar
import com.standalone.core.R
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name BaseActivity
 * @class name：com.lv.module_main.activity.base
 * @author 345 QQ:1831712732
 * @time 2020/5/8 22:52
 * @description Activity 基类
 */

abstract class BaseActivity<VM : BaseViewModel>() : AppCompatActivity() {

    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setViewModel()
        initView()
        lifecycle.addObserver(viewModel)
        initBar()
        bindView()
    }

    open fun initView() {
        val content = LayoutInflater.from(this).inflate(layout(), null, false)
        when {
            content != null -> {
                setContentView(content)
            }
            else -> {
                throw NullPointerException("布局初始化异常")
            }
        }
    }

    private fun setViewModel() {
        val viewModel = createViewModel()
        this.viewModel = if (viewModel != null) {
            ViewModelProvider(this).get(viewModel)
        } else {
            val stateViewModel = createStateViewModel()
                ?: throw NullPointerException("$this ---> ViewModel 为 null")
            ViewModelProvider(
                this, SavedStateViewModelFactory(application, this)
            ).get(stateViewModel)
        }
    }

    private fun initBar() {
        if (isImmersionBar()) {
            initBar(isBarDark(), toolBarResId())
            val view = findViewById<View>(toolBarResId())
            if (view is ViewGroup) {
                val back = view.findViewWithTag<View>("back")
                back?.setOnClickListener { finish() }
                val title = view.findViewWithTag<AppCompatTextView>("title")
                if (title != null && TextUtils.isEmpty(title.text)) {
                    title.text = toolbarTitle()
                }
                if (isWhiteToolbar()) {
                    Glide.with(this).load(R.drawable.left_white_start).into(back as ImageView)
                    title.setTextColor(Color.WHITE)
                }
            }

        }
    }

    private fun initBar(isDark: Boolean, resId: Int) {
        ImmersionBar.with(this)
            .statusBarDarkFont(isDark)
            .titleBar(findViewById<View>(resId))
            .init()
    }


    /**
     * 设置沉浸式，需手动调用
     *
     * @param isDark
     */
    fun initBar(isDark: Boolean) {
        initBar(isDark, toolBarResId())
    }


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
     * 是否开启沉浸式状态栏
     * 默认开启
     *
     * @return
     */
    open fun isImmersionBar(): Boolean = true

    /**
     * 设置状态栏颜色，false 表示 白色，true 为黑色
     *
     * @return
     */
    open fun isBarDark(): Boolean = true

    /**
     * 页面标题栏的 ID
     *
     * @return
     */
    open fun toolBarResId(): Int = View.NO_ID

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

    abstract fun layout(): Int

    abstract fun bindView()


}