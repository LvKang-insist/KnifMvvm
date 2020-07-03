package com.example.module_home.navigation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.standalone.core.base.viewmodel.BaseViewModel
import com.www.net.launchVmHttp

class HomeContentViewModel @ViewModelInject  constructor(
    private val response: HomeContentRepository,
    @Assisted val  state: SavedStateHandle
) : BaseViewModel(state) {

    private val liveData by lazy { MutableLiveData<String>() }

    val testLiveData: LiveData<String> by lazy { liveData }

    fun requestBaiDu() {
        launchVmHttp {
            liveData.postValue(response.requestBaidu())
        }
    }
}