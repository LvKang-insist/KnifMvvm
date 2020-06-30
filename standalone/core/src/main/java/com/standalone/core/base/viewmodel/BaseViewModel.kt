package com.standalone.core.base.viewmodel

import androidx.lifecycle.*
import com.elvishew.xlog.XLog
import com.standalone.core.base.model.BaseRepository

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
        XLog.e("------->销毁")
        mDefaultRepository = null
    }
}