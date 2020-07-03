package com.example.module_home

import android.util.Log
import javax.inject.Inject

class HiltTest @Inject constructor() {

    fun hiltTest(): String {
        Log.e("-------->", "hiltTest: ")
        return "首页"
    }
}