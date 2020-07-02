package com.lv.module_home

import com.elvishew.xlog.XLog
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object TestModule {

    /**
     * 每次都是新的实例
     */
    @Provides
    fun bindHiltTest(): HiltTest {
        XLog.e("--------bindHiltTest----")
        return HiltTest()
    }

    /**
     * 全局复用同一个实例
     */
    @Provides
    @Singleton
    fun bindSingTest(): Test {
        XLog.e("--------bindSingTest----")
        return Test()
    }

}