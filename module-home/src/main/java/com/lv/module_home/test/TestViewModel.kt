package com.lv.module_home.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.lv.library_core.base.viewmodel.BaseViewModel

class TestViewModel : BaseViewModel() {

    private val testRepository by lazy { TestRepository() }

    private val liveData by lazy { MutableLiveData<String>() }

    val testLiveData: LiveData<String> by lazy { liveData }

    fun requestBaiDu() {
        liveData.postValue(testRepository.request())
    }


}