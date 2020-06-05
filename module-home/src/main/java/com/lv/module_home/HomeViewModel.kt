package com.lv.module_home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.hjq.toast.ToastUtils
import com.lv.library_core.base.model.BaseRepository
import com.lv.library_core.base.model.DefaultRepository
import com.lv.library_core.base.viewmodel.BaseViewModel
import com.www.net.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.math.log

/**
 * @name HomeViewModel
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/5/19 23:03
 * @description
 */

class HomeViewModel : BaseViewModel() {

    val homeRepository by lazy { HomeRepository() }

    private val mutableLiveData by lazy { MutableLiveData<Result>() }
    val loginLiveData: LiveData<Result> = mutableLiveData

    fun login() {
        viewModelScope.launch {
            launchHttp {
                val login = homeRepository.login("https://www.baidu.com")
                if (login != null) mutableLiveData.postValue(login) else ToastUtils.show("网络错误")
            }
        }
    }

}

suspend fun launchHttp(block: suspend CoroutineScope.() -> Unit) = withContext(Dispatchers.IO) {
    block()
}