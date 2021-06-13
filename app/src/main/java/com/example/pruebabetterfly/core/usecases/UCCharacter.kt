package com.example.pruebabetterfly.core.usecases

import com.example.pruebabetterfly.core.entities.ECharacter
import kotlinx.coroutines.flow.Flow

interface UCCharacter {
    fun getCharacterById(characterId:String): Flow<ECharacter>

    fun getAllCharacter(): Flow<ArrayList<ECharacter>>
}