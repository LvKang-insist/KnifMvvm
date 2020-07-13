package com.example.module_home.navigation

import com.example.library_core.net.ApiServices
import com.lvhttp.net.LvHttp
import com.standalone.core.base.model.BaseRepository
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

/**
 * @name TestModel
 * @package com.lv.module_home.test
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:03
 * @description
 */

@ActivityScoped
class HomeContentRepository @Inject constructor() : BaseRepository() {

    suspend fun requestBaidu(): String {
        return LvHttp.createApi(ApiServices::class.java).baidu()
    }
}