package com.lv.module_home.test

import com.lv.library_core.model.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class TestViewModel : BaseViewModel() {


    fun request() {
        GlobalScope.launch {
            delay(2000)
            finally.postValue("请求成功")
        }
    }
}