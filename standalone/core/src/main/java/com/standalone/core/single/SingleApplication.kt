package com.standalone.core.single

import android.app.Application
import com.standalone.core.latte.Latte

class SingleApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        Latte.init(this)
            .withLog()
            .withToastUtils()
            .configure()
    }
}