package com.standalone.core.base.viewmodel

import androidx.lifecycle.*
import com.elvishew.xlog.XLog
import com.lvhttp.net.launch.launchVmHttp
import com.standalone.core.base.model.BaseRepository
import com.standalone.core.base.model.DefaultRepository

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description BaseViewModel ，
 */

abstract class BaseViewModel : ViewModel(), LifecycleObserver {


    private val repository by lazy { DefaultRepository() }

    private val finally by lazy { MutableLiveData<String>() }

    private val request by lazy { MutableLiveData<String>() }

    private val requestError by lazy { MutableLiveData<Throwable>() }


    /**
     * 默认的 get 请求
     */
    fun get(url: String) {
        launchVmHttp(error = {
            requestError.postValue(it)
        }) {
            val result = repository.get(url)
            request.postValue(result)
        }
    }

    /**
     * 默认的 post 请求
     */
    fun post(url: String, mutableMap: MutableMap<String, Any>) {
        launchVmHttp(error = {
            requestError.postValue(it)
        }) {
            val result = repository.post(url, mutableMap)
            request.postValue(result)
        }
    }


    /**
     * 获取请求数据的结果的 liveData
     * 可对数据进行观察
     */
    fun result(): LiveData<String> {
        return request
    }

    /**
     * 默认的请求失败后，会通过 requestError 进行通知
     */
    fun resultError(): LiveData<Throwable> {
        return requestError
    }

    /**
     * 可在数据处理完成时调用，用于弹出一些提示
     */
    fun getFinally(): LiveData<String> {
        return finally
    }

}