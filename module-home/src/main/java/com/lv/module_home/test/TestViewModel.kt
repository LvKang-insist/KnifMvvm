package com.lv.module_home.test

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModelStoreOwner
import com.lv.library_core.base.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class TestViewModel : BaseViewModel {


    constructor() : super()
    constructor(state: SavedStateHandle) : super(state)

    private val testRepository by lazy { TestRepository() }

    private val liveData by lazy { MutableLiveData<String>() }

    val testLiveData: LiveData<String> by lazy { liveData }



    fun requestBaiDu() {
        GlobalScope.launch {
            liveData.postValue(testRepository.request())
        }
    }


}