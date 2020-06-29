package com.lv.module_home

import com.lv.library_core.base.model.BaseRepository
import com.lv.library_core.net.ApiServices
import com.www.net.LvHttp

/**
 * @name HomeRepository
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/6/5 22:44
 * @description
 */
class HomeRepository : BaseRepository() {

    suspend fun login(): String {
        return LvHttp.createApi(ApiServices::class.java).baidu()
    }

}