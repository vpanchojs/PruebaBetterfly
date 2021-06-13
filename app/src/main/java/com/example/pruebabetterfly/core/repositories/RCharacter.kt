package com.example.pruebabetterfly.core.repositories

import com.example.pruebabetterfly.core.entities.ECharacter
import kotlinx.coroutines.flow.Flow

interface RCharacter {
    fun getCharacterById(characterId:String): Flow<ECharacter>

    fun getAllCharacter(): Flow<ArrayList<ECharacter>>
}