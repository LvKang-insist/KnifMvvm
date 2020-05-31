package com.lv.library_core.base.viewmodel

import androidx.lifecycle.*
import com.lv.library_core.base.model.BaseRepository
import com.www.net.Result

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    //Repository
    private var mDefaultRepository: BaseRepository? = null
        get() {
            if (field == null) field = object : BaseRepository() {}
            return field
        }

    //可在请求完成后调用，用于提示
    protected val finally by lazy { MutableLiveData<String>() }

    //默认的 liveData
    private val liveData by lazy { MutableLiveData<Result>() }
    val defaultLiveData: LiveData<Result> by lazy { liveData }

    /**
     * 可在数据处理完成时调用，用于弹出一些提示
     */
    fun getFinally(): LiveData<String> {
        return finally
    }

    /**
     * 默认的网络请求
     */
    fun getDefaultRequest(url: String) {
        mDefaultRepository?.request(url) {
            liveData.value = it
        }
    }

    fun getDefaultRequest(url: String, params: MutableMap<String, Any>) {
        mDefaultRepository?.request(url, params) {
            liveData.value = it
        }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mDefaultRepository = null
    }
}