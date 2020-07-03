package com.example.library_core.single

import android.app.Application
import com.standalone.core.latte.Latte

open class SingleApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Latte.init(this)
    }
}