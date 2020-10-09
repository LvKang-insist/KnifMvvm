package com.example.library_core.storage

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

/**
 * @author 345 QQ:1831712732
 * @package : com.example.library_core.storage
 * @time : 2020/10/9  22:28
 * @description :
 */

val MIGRATION_1_2 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""alter table user add column love char not null default "" """)
    }
}
val MIGRATION_2_3 = object : Migration(1,2){
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("""alter table user add column ccc char not null default "" """)
    }
}