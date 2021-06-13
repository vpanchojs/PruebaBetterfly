package com.example.pruebabetterfly.core.usecases


import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.core.repositories.RCharacter
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import javax.inject.Inject

class UCCharacterImp @Inject constructor(private val rCharacter: RCharacter): UCCharacter {

    override fun getCharacterById(characterId: String): Flow<ECharacter> {
        return rCharacter.getCharacterById(characterId).transform { value->
            //Se ejecutara logica adicional
            emit(value)
        }
    }

    override fun getAllCharacter(): Flow<ArrayList<ECharacter>> {
        return rCharacter.getAllCharacter().transform { value ->
            //Se ejecutara logica adicional
            emit(value)
        }
    }

}