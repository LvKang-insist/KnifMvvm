package com.lv.module_home.navigation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.lvhttp.net.launch.launchVmHttp
import com.standalone.core.base.viewmodel.BaseSaveStateViewModel
import kotlinx.coroutines.launch

class HomeContentViewModel : BaseSaveStateViewModel {

    constructor() : super()
    constructor (state: SavedStateHandle) : super(state)

    private val liveData by lazy { MutableLiveData<String>() }

    val testLiveData: LiveData<String> by lazy { liveData }

    val repository by lazy { HomeContentRepository() }

    fun requestBaiDu() {
        launchVmHttp {
            liveData.postValue(repository.requestBaidu())
        }
        viewModelScope.launch {

        }
    }
}