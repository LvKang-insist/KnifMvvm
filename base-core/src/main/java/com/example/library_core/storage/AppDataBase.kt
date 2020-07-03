package com.example.library_core.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.library_core.storage.bean.User
import com.example.library_core.storage.dao.UserDao

/**
 * @name RoomDataBase
 * @package com.lv.library_core.utils.storage
 * @author 345 QQ:1831712732
 * @time 2020/6/8 21:45
 * @description
 */
@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

}