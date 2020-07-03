package com.example.admin

import android.util.Log
import javax.inject.Inject

/**
 * @author 345 QQ:1831712732
 * @name HiltTest
 * @package com.lv.admin
 * @time 2020/7/2 20:32
 * @description
 */
class HiltTest @Inject constructor() {

    fun hiltTest() {
        Log.e("----------->", "hiltTest: ")
    }
}