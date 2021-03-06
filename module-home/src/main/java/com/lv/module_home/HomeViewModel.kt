package com.lv.module_home

import android.util.Log
import androidx.lifecycle.*
import com.lvhttp.net.launch.launchVmHttp
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name HomeViewModel
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/19 23:03
 * @description
 */

class HomeViewModel : BaseViewModel() {

    private val homeRepository by lazy { HomeRepository() }


    private val loginLiveData by lazy { MutableLiveData<String>() }
    val loginObserver: LiveData<String> = loginLiveData


    fun login() {
        launchVmHttp {
            val login = homeRepository.login()
            loginLiveData.postValue(login)
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.e("-------->", "onStart")
    }
}

