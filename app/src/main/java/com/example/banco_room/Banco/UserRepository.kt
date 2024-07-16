package com.example.banco_room.Banco

import android.content.Context

class UserRepository(context: Context) {
    private val userDatabase = UserDatabase.getDatabase(context).userDao()

    fun get_all(): List<UserEntity> {
        return userDatabase.get_all()
    }


    fun get_by_id(id: Int): UserEntity {
        return userDatabase.get_by_id(id)
    }


    fun delete(userEntity: UserEntity): Int {
        return userDatabase.delete(userEntity)
    }


    fun post(userEntity: UserEntity): Long {
        return userDatabase.post(userEntity)
    }


    fun update(userEntity: UserEntity): Int {
        return userDatabase.update(userEntity)
    }

}