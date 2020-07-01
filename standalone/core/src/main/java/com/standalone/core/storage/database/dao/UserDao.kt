package com.standalone.core.storage.database.dao

import androidx.paging.DataSource
import androidx.room.*
import com.standalone.core.storage.database.user.User


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

    @Query("select *from user")
    fun queryUser(): DataSource.Factory<Int, User>

    @Delete
    fun delete(user: User)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(user: User)
}
