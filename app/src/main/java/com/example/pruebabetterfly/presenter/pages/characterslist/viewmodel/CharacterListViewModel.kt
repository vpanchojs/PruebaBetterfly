package com.example.pruebabetterfly.presenter.pages.characterslist.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.core.usecases.UCCharacter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(private val ucCharacter: UCCharacter) : ViewModel() {
    val characterList = MutableLiveData<ArrayList<ECharacter>>()
    var characters = ArrayList<ECharacter>()
    val message = MutableLiveData<String>()


    fun getAllCharacter() {

        viewModelScope.launch {
            ucCharacter.getAllCharacter().onStart {
                Log.e("obtener personaje", "inicio el loading")
                message.postValue("Obtener data")
            }.catch { e -> Log.e("obtener personaje", e.message.toString())
                message.postValue(e.message.toString())
            }
                .collect {
                    characterList.postValue(it)
                }
            
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel();
    }
}