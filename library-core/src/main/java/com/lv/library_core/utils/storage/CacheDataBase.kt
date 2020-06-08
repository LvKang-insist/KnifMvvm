package com.lv.library_core.utils.storage

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lv.library_core.latte.Latte

/**
 * @name RoomDataBase
 * @package com.lv.library_core.utils.storage
 * @author 345 QQ:1831712732
 * @time 2020/6/8 21:45
 * @description
 */
abstract class CacheDataBase : RoomDatabase() {

    companion object {

        val database = Room.databaseBuilder(
            Latte.getAppContext(), CacheDataBase::class.java, "knife_cache"
        )
            //是否允许在主线程进行查询
            .allowMainThreadQueries()
            //打开和创建的回调
//                .addCallback()
            //设置查询时的线程池
//                .setQueryExecutor()
            //设置数据库工厂
//                .openHelperFactory()
            //room 的日志模式
//                .setJournalMode()
            //数据库升级异常后的回滚
//                .fallbackToDestructiveMigration()
            //数据库升级异常后根据指定版本进行回滚
//                .fallbackToDestructiveMigrationFrom()
            //向数据库添加迁移，每次迁移都要有开始和最后版本，Room 将将迁移到最新版本
            //如果没有迁移对象，则数据库会重新创建
//                .addMigrations(CacheDatabase.sMigration)
            .build()

        /**
         * 获取数据库
         */
        fun get(): CacheDataBase {
            return database
        }

    }

    abstract fun <T> getDao(): T
}