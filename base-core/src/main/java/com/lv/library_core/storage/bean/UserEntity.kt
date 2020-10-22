package com.lv.library_core.storage.bean

import androidx.room.*

/**
 * @name User
 * @package com.lv.module_sort.dao
 * @author 345 QQ:1831712732
 * @time 2020/6/8 21:53
 * @description
 */

/**
 * @name User
 * @package com.lv.module_sort
 * @author 345 QQ:1831712732
 * @time 2020/6/8 20:20
 * @description User 表
 */
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var name: String,
    var age: Int,
    var love: String,
    val ccc: String,
    var sex: String
)