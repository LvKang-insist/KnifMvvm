package com.example.module_home

import androidx.lifecycle.*
import com.standalone.core.base.viewmodel.BaseViewModel
import com.www.net.launchVmHttp
/**
 * @name HomeViewModel
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/19 23:03
 * @description
 */

class HomeViewModel : BaseViewModel() {

    val homeRepository by lazy { HomeRepository() }

    private val mutableLiveData by lazy { MutableLiveData<String>() }
    val loginLiveData: LiveData<String> = mutableLiveData

    fun login() {
        launchVmHttp {
            val login = homeRepository.login()
            mutableLiveData.postValue(login)
        }
    }

}

