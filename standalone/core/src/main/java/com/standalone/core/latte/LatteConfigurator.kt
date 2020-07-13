package com.standalone.core.latte


/**
 * @name LatteConfigurator
 * @package com.lv.library_core.latte
 * @author 345 QQ:1831712732
 * @time 2020/5/15 21:15
 * @description
 */
object LatteConfigurator {

    private val LATTE_CONFIG = LinkedHashMap<LatteConfigKeys, Any>()

    /**
     * 配置完成时调用
     */
    fun configure() {
        LATTE_CONFIG[LatteConfigKeys.CONFIG_READER] = true
    }

    /**
     * put
     */
    fun put(configKeys: LatteConfigKeys, any: Any): LatteConfigurator {
        LATTE_CONFIG[configKeys] = any
        return this
    }

    /**
     * @return 返回全部配置
     */
    fun getLatteConfigs(): LinkedHashMap<LatteConfigKeys, Any> {
        return LATTE_CONFIG
    }

    /**
     * 返回某一项配置
     */
    fun <T> getConfigurator(key: LatteConfigKeys): T {
        val o = LATTE_CONFIG[key] ?: throw NullPointerException(key.toString() + "is NULL")
        return o as T
    }

}