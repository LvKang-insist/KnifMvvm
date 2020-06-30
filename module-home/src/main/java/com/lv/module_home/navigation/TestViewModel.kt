package com.lv.module_home.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.standalone.core.base.viewmodel.BaseViewModel

class TestViewModel : BaseViewModel {


    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)

    private val testRepository by lazy { TestRepository() }

    private val liveData by lazy { MutableLiveData<String>() }

    val testLiveData: LiveData<String> by lazy { liveData }



    fun requestBaiDu() {
//        GlobalScope.launch {
//            liveData.postValue(testRepository.request())
//        }
    }


}