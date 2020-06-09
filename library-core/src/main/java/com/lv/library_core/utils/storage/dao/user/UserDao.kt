package com.lv.library_core.utils.storage.dao.user

import androidx.room.*
import com.lv.library_core.utils.storage.dao.user.User

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
    fun save(user: User): Long

    @Query("select *from user where   `id`= :id")
    fun getCache(id: Int): User

    @Delete
    fun delete(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: User)
}
