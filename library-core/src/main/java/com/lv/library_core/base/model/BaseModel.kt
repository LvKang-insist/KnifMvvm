package com.lv.library_core.base.model

import androidx.lifecycle.LiveData
import com.elvishew.xlog.XLog
import com.www.net.LvHttp
import com.www.net.Result

/**
 * @name BaseModel
 * @package com.lv.library_core.base.model
 * @author 345 QQ:1831712732
 * @time 2020/5/19 21:52
 * @description
 */
abstract class BaseModel {

    /**
     * 普通的网络请求
     */
    fun request(url: String, block: ((Result) -> Unit)) {
        LvHttp
            .get(url)
            .send {
                block(it)
            }
    }

    /**
     * 带参网络请求
     */
    fun request(url: String, params: MutableMap<String, Any>, block: (Result) -> Unit) {
        LvHttp
            .get(url)
            .addParam(params)
            .send {
                block(it)
            }
    }

}