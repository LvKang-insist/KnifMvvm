package com.lv.module_home

import com.lv.library_core.base.model.BaseRepository
import com.www.net.LvHttp
import com.www.net.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * @name HomeRepository
 * @package com.lv.module_home
 * @author 345 QQ:1831712732
 * @time 2020/6/5 22:44
 * @description
 */
class HomeRepository : BaseRepository() {

    fun login(url: String): Result? {
        return LvHttp.get()
            .addUrl(url)
            .send()
    }

}