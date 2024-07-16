package com.example.banco_room.Banco

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(tableName = "Users", indices = [Index(value = ["Cpf"], unique = true)])
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    var uid: Int = 0,

    @ColumnInfo(name = "Nome")
    var Nome: String = "",

    @ColumnInfo(name = "Cpf")
    var Cpf: String = ""
)
