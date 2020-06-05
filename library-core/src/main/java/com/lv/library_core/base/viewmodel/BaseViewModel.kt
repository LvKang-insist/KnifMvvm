package com.lv.library_core.base.viewmodel

import androidx.lifecycle.*
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.model.BaseRepository
import com.www.net.Result

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description BaseViewModel ，
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel : ViewModel, LifecycleObserver {

    /**
     * ViewModel 在内存不足时被干掉后的数据恢复
     * 包括在页面转屏的时候都会通知对应的观察者
     */
    private lateinit var savedStateHandler: SavedStateHandle

    //可在请求完成后调用，用于提示
    protected val finally by lazy { MutableLiveData<String>() }

    //默认的 liveData
    private val liveData by lazy { MutableLiveData<Result>() }
    val defaultLiveData: LiveData<Result> by lazy { liveData }


    constructor() : super()

    constructor(state: SavedStateHandle) : super() {
        this.savedStateHandler = state
    }

    //Repository
    private var mDefaultRepository: BaseRepository? = null
        get() {
            if (field == null) field = object : BaseRepository() {}
            return field
        }

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

    /**
     * 保存数据到 savedStateHandler
     */
    fun <T> saveCurrentValue(key: String, t: T) {
        savedStateHandler.set(key, t)
    }

    /**
     * 从 savedStateHandler 取出数据
     */
    fun <T> getCurrentValue(key: String): T? {
        return savedStateHandler.get(key)
    }

    /**
     * 获取指定 savedStateHandler key 的 liveData
     */
    fun <T> getSaveStateLiveData(key: String): LiveData<T> {
        return savedStateHandler.getLiveData(key)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mDefaultRepository = null
    }
}