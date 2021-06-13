package com.example.pruebabetterfly.presenter.pages.login.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebabetterfly.core.entities.EUser
import com.example.pruebabetterfly.core.usecases.UCUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val ucUser: UCUser) : ViewModel() {
    val userModel = MutableLiveData<EUser>()
    val message = MutableLiveData<String>()

    fun signIn(user:String,password:String) {

        viewModelScope.launch {
            ucUser.signIn(user,password).onStart {
                Log.e("LoginVM", "inicio el loading")
            }.catch { e ->
                Log.e("LoginVM", e.message.toString())
                message.postValue(e.message.toString())
            }
                .collect {
                    userModel.postValue(it)
                }
            
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel();
    }
}