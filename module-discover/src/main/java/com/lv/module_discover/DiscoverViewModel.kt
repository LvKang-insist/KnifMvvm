package com.lv.module_discover

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.standalone.core.base.viewmodel.BaseViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*

/**
 * @name DiscoverViewModel
 * @package com.lv.module_discover
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:59
 * @description
 */
class DiscoverViewModel : BaseViewModel() {

    private val _discover by lazy { MutableLiveData<TestBean>() }
    val discover: LiveData<TestBean> = _discover


    var bean: TestBean = TestBean()

    fun requestBean() {
        bean.sum.set(0)
        _discover.postValue(bean)
    }

    fun addSum() {
        bean.addSum()
    }

}