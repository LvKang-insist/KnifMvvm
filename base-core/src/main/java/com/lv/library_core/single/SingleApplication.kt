package com.lv.library_core.single

import android.app.Application
import com.standalone.core.latte.Latte
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SingleApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Latte.init(this)
    }
}