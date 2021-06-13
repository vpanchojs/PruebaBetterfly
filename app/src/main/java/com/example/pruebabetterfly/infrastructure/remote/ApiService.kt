package com.example.pruebabetterfly.infrastructure.remote

import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.infrastructure.remote.model.ResponseApiRickMorty
import retrofit2.http.GET
import retrofit2.http.Path


interface ApiService {

    @GET("character")
    suspend fun getAllCharacter(): ResponseApiRickMorty<ArrayList<ECharacter>>

    @GET("character/{characterId}")
    suspend fun getCharacterById(@Path("characterId") characterId:String):ECharacter

}