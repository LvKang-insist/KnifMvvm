package com.lv.library_core.model

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description
 */
abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    /**
     * 可在请求完成后调用，用于提示
     */
    private val finally by lazy { MutableLiveData<String>() }


    fun getFinally(): LiveData<String> {
        return finally
    }


}