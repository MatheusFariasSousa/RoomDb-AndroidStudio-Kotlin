package com.example.banco_room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.banco_room.Banco.UserEntity
import com.example.banco_room.databinding.RowUserBinding

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    private var userList: List<UserEntity> = listOf()
    private lateinit var listener: OnUserListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val item = RowUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(item, listener)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(userList[position])
    }

    fun updateUsers(list: List<UserEntity>) {
        userList = list
        notifyDataSetChanged()
    }
    fun attachListener(userListener:OnUserListener){
        listener = userListener
    }

}