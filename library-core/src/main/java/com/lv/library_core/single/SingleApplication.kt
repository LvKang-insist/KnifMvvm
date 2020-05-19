package com.lv.library_core.single

import android.app.Application
import com.lv.library_core.latte.Latte

class SingleApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Latte.init(this)
            .withLog()
            .withToastUtils()
            .configure()
    }
}