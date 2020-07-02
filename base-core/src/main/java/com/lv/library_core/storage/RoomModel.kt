package com.lv.library_core.storage

import android.app.Application
import android.util.Log
import androidx.room.Room
import com.lv.library_core.storage.dao.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RoomModel {

    /**
     * @Provides：常用于被 @Module 标记类的内部方法，并提供依赖对象
     * @Singleton：提供单例
     */
    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): AppDataBase {
        Log.e("-------", "provideAppDataBase: 执行")
        return Room
            .databaseBuilder(application, AppDataBase::class.java, "knif.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun providerUserDao(appDataBase: AppDataBase): UserDao {
        Log.e("-------", "provideAppDataBase: 获取")
        return appDataBase.getUserDao()
    }
}