package com.example.pruebabetterfly.core.usecases

import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.core.entities.EUser
import kotlinx.coroutines.flow.Flow
import java.util.*

interface UCUser {
    fun signIn(user:String,password:String): Flow<EUser>
}