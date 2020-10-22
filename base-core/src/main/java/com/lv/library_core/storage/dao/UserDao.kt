package com.lv.library_core.storage.dao

import androidx.room.*
import com.lv.library_core.storage.bean.UserEntity


/**
 * @name UserDao
 * @package com.lv.library_core.utils.storage.dao
 * @author 345 QQ:1831712732
 * @time 2020/6/9 22:47
 * @description
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(userEntity: UserEntity): Long

    @Query("select * from user where `id`=:id")
    fun queryUser(id: Int): UserEntity

    @Query("select * from user")
    fun queryAll():List<UserEntity>

    @Delete
    fun delete(userEntity: UserEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(userEntity: UserEntity)

}
