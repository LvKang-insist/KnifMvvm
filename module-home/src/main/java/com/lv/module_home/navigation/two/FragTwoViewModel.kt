package com.lv.module_home.navigation.two

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.lv.library_core.storage.bean.User
import com.lv.library_core.storage.dao.UserDao
import com.standalone.core.base.viewmodel.BaseViewModel
import javax.inject.Inject

class FragTwoViewModel : BaseViewModel() {


    /*@Inject
    lateinit var userDao: UserDao


    val user = MutableLiveData<PagedList<User>>()

    fun request() {
        //创建 DataSource.Factory
        val factory = userDao.queryUser()

        //2,通过 LivePageListBuild 配置工厂和 pageSize，对 users 进行实例化
        user.postValue(LivePagedListBuilder(factory, 15).build().value)
    }*/

}