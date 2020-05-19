package com.lv.library_core.base.viewmodel

import androidx.lifecycle.*
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.model.BaseModel

/**
 * @name BaseViewModel
 * @package com.lv.library_core.model
 * @author 345 QQ:1831712732
 * @time 2020/5/12 22:44
 * @description
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewModel : ViewModel(), LifecycleObserver {


    private var mModel: BaseModel? = null


    /**
     * 可在请求完成后调用，用于提示
     */
    protected val finally by lazy { MutableLiveData<String>() }

    fun getFinally(): LiveData<String> {
        return finally
    }

    open fun setModel(): BaseModel? = null

    fun <M : BaseModel> getModel(): M? {
        if (mModel == null) mModel = setModel()
        return mModel as M
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mModel = null
    }
}