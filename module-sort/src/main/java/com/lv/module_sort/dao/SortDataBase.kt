package com.lv.module_sort.dao;

import androidx.constraintlayout.solver.Cache
import androidx.room.Database;
import com.lv.library_core.utils.storage.CacheDataBase
import com.lv.module_sort.User

/**
 * @author 345 QQ:1831712732
 * @name SortDataBase
 * @package com.lv.module_sort.dao
 * @time 2020/6/8 22:43
 * @description
 */
@Database(entities = [User::class], version = 1, exportSchema = true)
abstract class SortDataBase : CacheDataBase() {

    companion object {
        fun get(): CacheDataBase {
            return database
        }
    }

}
