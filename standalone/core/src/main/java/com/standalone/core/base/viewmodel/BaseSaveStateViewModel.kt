package com.standalone.core.base.viewmodel

import androidx.lifecycle.*
import com.standalone.core.base.model.BaseRepository
import com.standalone.core.base.model.DefaultRepository

abstract class BaseSaveStateViewModel : BaseViewModel, LifecycleObserver {

    /**
     * ViewModel 在内存不足时被干掉后的数据恢复
     * 包括在页面转屏的时候都会通知对应的观察者
     */
    private lateinit var savedStateHandler: SavedStateHandle


    constructor() : super()
    constructor(
        state: SavedStateHandle
    ) : super() {
        this.savedStateHandler = state
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


}