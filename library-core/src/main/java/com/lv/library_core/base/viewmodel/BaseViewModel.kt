package com.lv.library_core.base.viewmodel

import androidx.lifecycle.*
import com.lv.library_core.base.model.BaseModel
import com.www.net.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel : ViewModel(), LifecycleObserver {

    //BaseModel
    private var mModel: BaseModel? = null
        get() {
            if (field == null) field = setModel()
            return field
        }

    //可在请求完成后调用，用于提示
    protected val finally by lazy { MutableLiveData<String>() }

    //默认的 liveData
    protected val defaultRequest by lazy { MutableLiveData<Result>() }

    /**
     * 可在数据处理完成时调用，用于弹出一些提示
     */
    fun getFinally(): LiveData<String> {
        return finally
    }

    /**
     * 默认的网络请求
     */
    fun getDefaultRequest(url: String): LiveData<Result> {
        mModel?.request(url) {
            defaultRequest.value = it
        }
        return defaultRequest
    }

    fun getDefaultRequest(url: String, params: MutableMap<String, Any>): LiveData<Result> {
        mModel?.request(url, params) {
            defaultRequest.value = it
        }
        return defaultRequest
    }


    /**
     * 设置 Model
     */
    open fun setModel(): BaseModel? = null

    /**
     * 获取 Model
     */
    fun <M : BaseModel> getModel(): M? {
        return mModel as M
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mModel = null
    }
}