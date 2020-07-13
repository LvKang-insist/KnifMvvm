package com.example.module_home.navigation

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.lvhttp.net.launch.launchVmHttp
import com.standalone.core.base.viewmodel.BaseViewModel
import kotlinx.coroutines.launch

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
        viewModelScope.launch {

        }
    }
}