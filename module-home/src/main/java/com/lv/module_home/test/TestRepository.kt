package com.lv.module_home.test

import com.elvishew.xlog.XLog
import com.lv.library_core.base.model.BaseRepository
import com.www.net.LvHttp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @name TestModel
 * @package com.lv.module_home.test
 * @author 345 QQ:1831712732
 * @time 2020/5/19 22:03
 * @description
 */

class TestRepository : BaseRepository() {


    fun request(): String? {
        return LvHttp.post()
            .addUrl("https://www.baidu.com")
            .send()?.value
    }

}