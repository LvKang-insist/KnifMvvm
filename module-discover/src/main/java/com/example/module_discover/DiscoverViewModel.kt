package com.example.module_discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.hjq.toast.ToastUtils
import com.standalone.core.base.viewmodel.BaseViewModel

/**
 * @name DiscoverViewModel
 * @package com.lv.module_discover
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:59
 * @description
 */
class DiscoverViewModel : BaseViewModel() {


    private val discoverLiveData by lazy { MutableLiveData<TestBean>() }
    val discoverLiveDataObserver: LiveData<TestBean> = discoverLiveData

    var bean: TestBean = TestBean()

    fun requestBean() {
        bean.sum.set(0)
        discoverLiveData.postValue(bean)
    }

    fun addSum() {
        bean.addSum()
    }

}