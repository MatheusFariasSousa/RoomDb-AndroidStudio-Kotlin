package com.example.banco_room.Banco

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserDao {

    @Query("SELECT * FROM Users")
    fun get_all(): List<UserEntity>

    @Query("SELECT * FROM Users WHERE uid = (:id)")
    fun get_by_id(id: Int):UserEntity

    @Delete
    fun delete(userEntity: UserEntity):Int

    @Insert
    fun post(userEntity: UserEntity):Long

    @Update
    fun update(userEntity: UserEntity):Int

}