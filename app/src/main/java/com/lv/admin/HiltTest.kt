package com.lv.admin

import android.util.Log
import javax.inject.Inject

class HiltTest @Inject constructor() {

    fun hiltTest() {
        Log.e("-------->", "hiltTest: ")
    }
}