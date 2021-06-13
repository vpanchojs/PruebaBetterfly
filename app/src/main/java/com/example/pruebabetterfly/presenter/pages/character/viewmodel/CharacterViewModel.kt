package com.example.pruebabetterfly.presenter.pages.character.viewmodel

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
class CharacterViewModel @Inject constructor(private val ucCharacter: UCCharacter) : ViewModel() {
    val characterModel = MutableLiveData<ECharacter>()
    val message = MutableLiveData<String>()

    fun getCharacterById(characterId: String) {
        viewModelScope.launch {
            ucCharacter.getCharacterById(characterId).onStart {
                Log.e("obtener personaje", "inicio el loading")
                message.postValue("Obteniendo data")
            }.catch { e ->
                Log.e("obtener personaje", e.message.toString())
                message.postValue(e.message.toString())
            }
                .collect {
                    characterModel.postValue(it)
                }
        }
    }


    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel();
    }
}