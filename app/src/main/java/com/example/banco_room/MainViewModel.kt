package com.example.banco_room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.banco_room.Banco.UserEntity
import com.example.banco_room.Banco.UserRepository

class MainViewModel(application: Application):AndroidViewModel(application) {

    private val repository =UserRepository(application.applicationContext)

    private val listUsers = MutableLiveData<List<UserEntity>>()
    val users:LiveData<List<UserEntity>> = listUsers

    private val userModel = MutableLiveData<UserEntity>()
    val user:LiveData<UserEntity> = userModel

    private var changes = MutableLiveData<Long>()
    var newChanges:LiveData<Long> = changes


    fun getAll(){
        listUsers.value = repository.get_all()

    }
    fun get(id:Int){
        userModel.value = repository.get_by_id(id)

    }

    fun insert(username:String,cpf:String){
        val model = UserEntity().apply {
            this.Nome = username
            this.Cpf = cpf
        }
        changes.value = repository.post(model)
    }

    fun update(uid:Int,username:String,cpf:String){
        val model = UserEntity().apply {
            this.uid = uid
            this.Nome = username
            this.Cpf = cpf
        }
        changes.value = repository.update(model).toLong()
    }
    fun delete(uid:Int){
        val model = UserEntity().apply {
            this.uid = uid
        }
        changes.value = repository.delete(model).toLong()
    }



}