package com.standalone.core.storage.mmkv
//
//import com.tencent.mmkv.MMKV
//
//object SpUtils {
//
//    private val mv = MMKV.defaultMMKV()
//
//    /**
//     * 保存一个字符串
//     */
//    fun putString(key: String, string: String) {
//        mv.encode(key, string)
//    }
//
//    /**
//     * 获取一个字符串
//     */
//    fun getString(key: String): String {
//        return mv.decodeString(key)
//    }
//
//    /**
//     * 清除 key
//     */
//    fun removeKey(key: String) {
//        return mv.removeValueForKey(key)
//    }
//
//    /**
//     * 清除所有 key
//     */
//    fun clearAll() {
//        mv.clearAll()
//    }
//}