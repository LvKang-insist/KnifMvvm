package com.lv.module_home.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelStore
import com.lv.library_core.base.activity.BaseLayoutActivity
import com.lv.module_home.R

class TestActivity : BaseLayoutActivity<TestViewModel>() {
    override fun setViewModel(): Class<TestViewModel> = TestViewModel::class.java

    override fun layout(): Int {
        return R.layout.text_activity
    }

    override fun bindView() {
        viewModel.request()
    }

}