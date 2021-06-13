package com.example.pruebabetterfly.infrastructure.remote

import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.core.repositories.RCharacter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RCharacterImp @Inject constructor(private val request: ApiService) : RCharacter {

    override fun getCharacterById(characterId: String): Flow<ECharacter> {
        return flow {
            val response: ECharacter = request.getCharacterById(characterId)
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

    override fun getAllCharacter(): Flow<ArrayList<ECharacter>> {
        return flow {
            val response: ArrayList<ECharacter> =
                request.getAllCharacter().results
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}