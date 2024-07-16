package com.example.banco_room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.banco_room.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private val adapter = UserAdapter()
    private var uid = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        binding.recicleUsers.layoutManager = LinearLayoutManager(applicationContext)
        binding.recicleUsers.adapter = adapter

        val listener = object  :OnUserListener{
            override fun OnClick(id: Int) {
                Toast.makeText(applicationContext,id.toString(),Toast.LENGTH_SHORT).show()

            }
        }

        adapter.attachListener(listener)

        binding.buttonInserir.setOnClickListener{
            val username = binding.textNome.text.toString()
            val cpf = binding.textCpf.text.toString()

            viewModel.insert(username,cpf)

        }
        binding.buttonAtualizar.setOnClickListener{
            val username = binding.textNome.text.toString()
            val cpf = binding.textCpf.text.toString()

            viewModel.update(uid,username,cpf)

        }
        binding.buttonDeletar.setOnClickListener{
            viewModel.delete(uid)

        }
        observe()
        viewModel.getAll()
    }

    private fun observe() {
        viewModel.users.observe(this){
            adapter.updateUsers(it)
        }
        viewModel.user.observe(this){
            uid= it.uid
            binding.textId.setText(uid.toString())
            binding.textNome.setText(it.Nome)
            binding.textCpf.setText(it.Cpf)
        }
        viewModel.newChanges.observe(this){
            viewModel.getAll()
        }

    }


}