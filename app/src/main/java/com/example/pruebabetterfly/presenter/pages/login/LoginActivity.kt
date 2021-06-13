package com.example.pruebabetterfly.presenter.pages.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.pruebabetterfly.databinding.ActivityLoginBinding
import com.example.pruebabetterfly.presenter.pages.characterslist.CharacterListActivity
import com.example.pruebabetterfly.presenter.pages.login.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.userModel.observe(this, Observer {
            if (it != null) {
                val intent= Intent(this,CharacterListActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or
                        Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                finish()
            }
        })

        binding.btnSignin.setOnClickListener {
            viewModel.signIn(binding.tiEmail.text.toString(),binding.tiPassword.text.toString())
        }

        viewModel.message.observe(
            this,{
                Toast.makeText(this,it,Toast.LENGTH_SHORT).show()
            }
        )




    }
}