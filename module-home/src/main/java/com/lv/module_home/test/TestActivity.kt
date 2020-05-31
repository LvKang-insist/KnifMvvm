package com.lv.module_home.test

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStore
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.ui.activity.BaseBindingActivity
import com.lv.library_core.base.ui.activity.BaseLayoutActivity
import com.lv.module_home.R
import com.lv.module_home.databinding.TextActivityBinding
import kotlinx.android.synthetic.main.layout_toolbar.*

class TestActivity : BaseBindingActivity<TextActivityBinding, TestViewModel>() {

    override fun setViewModel(): Class<TestViewModel> = TestViewModel::class.java

    override fun layout(): Int {
        return R.layout.text_activity
    }

    override fun bindView() {

        toolbar_title.setOnClickListener {
            viewModel.requestBaiDu()
        }

        viewModel.testLiveData.observe(this, Observer {
            ToastUtils.show(if (!TextUtils.isEmpty(it)) it else "请求错误")
        })
    }


}