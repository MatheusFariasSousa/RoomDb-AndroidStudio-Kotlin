package com.example.banco_room

import androidx.recyclerview.widget.RecyclerView
import com.example.banco_room.Banco.UserEntity
import com.example.banco_room.databinding.RowUserBinding

class UserViewHolder(private val bind:RowUserBinding,private val listener:OnUserListener)
    :RecyclerView.ViewHolder(bind.root) {

        fun bind(user:UserEntity){
            bind.textRowName.text=user.Nome
            bind.textRowCpf.text =user.Cpf


            bind.textRowName.setOnClickListener {
                listener.OnClick(user.uid)
            }

        }
}