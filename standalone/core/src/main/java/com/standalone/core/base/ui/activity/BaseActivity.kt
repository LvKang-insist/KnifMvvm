package com.example.library_core.base.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
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
        viewModel = ViewModelProvider(
            this,
            SavedStateViewModelFactory(application, this)
        ).get(setViewModel())
        lifecycle.addObserver(viewModel)
        initView()
        bindView(savedInstanceState)
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

    abstract fun setViewModel(): Class<VM>

    abstract fun layout(): Int

    abstract fun bindView()

    open fun bindView(savedInstanceState: Bundle?) {}


}