package com.lv.module_sort

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @name User
 * @package com.lv.module_sort
 * @author 345 QQ:1831712732
 * @time 2020/6/8 20:20
 * @description
 */
@Entity(tableName = "user")
class User(id: Int, name: String, age: Int) {

    @PrimaryKey
    var id: Int = 0

    var name: String = ""
    var age: Int = 0

    init {
        this.id = id
        this.name = name
        this.age = age
    }

    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}