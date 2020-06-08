package com.lv.module_sort.dao

import androidx.room.*
import com.lv.module_sort.User

/**
 * @name User
 * @package com.lv.module_sort.dao
 * @author 345 QQ:1831712732
 * @time 2020/6/8 21:53
 * @description
 */
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(user: User): Long

    @Query("select *from user where   `name`= :name")
    fun getCache(name: String): User

    @Delete
    fun delete(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: User)
}