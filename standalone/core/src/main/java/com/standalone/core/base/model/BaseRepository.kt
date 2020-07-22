package com.standalone.core.base.model

import com.lvhttp.net.LvHttp
import com.standalone.core.ApiService

/**
 * @name BaseRepository
 * @package com.lv.library_core.base.model
 * @author 345 QQ:1831712732
 * @time 2020/5/19 21:52
 * @description 基础的数据类
 */
abstract class BaseRepository {

    /**
     * 初始化 api 接口
     */
    val lvHttp by lazy { LvHttp.createApi(ApiService::class.java) }

    /**
     * 默认的网络请求
     */
    suspend fun get(url: String): String {
        return lvHttp.get(url)
    }

    suspend fun post(url: String, mutableMap: MutableMap<String, Any>): String {
        return lvHttp.post(url, mutableMap)
    }
}