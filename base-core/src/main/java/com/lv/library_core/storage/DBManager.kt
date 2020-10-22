package com.lv.library_core.storage

import androidx.room.Room
import com.lv.library_core.storage.bean.UserEntity
import com.standalone.core.latte.Latte

/**
 * @author 345 QQ:1831712732
 * @package : com.example.library_core.storage
 * @time : 2020/10/9  21:26
 * @description : 数据库管理器
 */
object DBManager {

  private  val database by lazy {
        Room.databaseBuilder(
            Latte.getAppContext(), AppDataBase::class.java, "knife"
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
            .fallbackToDestructiveMigrationFrom()
            //向数据库添加迁移，每次迁移都要有开始和最后版本，Room 将将迁移到最新版本
            //如果没有迁移对象，则数据库会重新创建
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()
    }



    /**
     * 保存 User 数据
     */
    fun insertUser(userEntity: UserEntity){
        database.getUserDao().insert(userEntity)
    }

    /**
     * 获取 User
     */
    fun queryUser():List<UserEntity>{
       return database.getUserDao().queryAll()
    }
}