package com.lv.module_sort

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.standalone.core.base.viewmodel.BaseViewModel
import com.standalone.core.storage.CacheDataBase
import com.standalone.core.storage.dao.user.User

/**
 * @name SortViewModel
 * @package com.lv.module_sort
 * @author 345 QQ:1831712732
 * @time 2020/5/19 23:08
 * @description
 */

class SortViewModel : BaseViewModel() {

//    val users: LiveData<PagedList<User>>

    init {
        //创建 DataSource.Factory
//        val factory = CacheDataBase.get().getUser().queryUser()

        //2,通过 LivePageListBuild 配置工厂和 pageSize，对 users 进行实例化
//        users = LivePagedListBuilder(factory, 15).build()
    }

}