package com.example.pruebabetterfly.core.repositories

import com.example.pruebabetterfly.core.entities.EUser
import kotlinx.coroutines.flow.Flow
import java.util.*

interface RUser {
    fun signIn(user:String, password:String): Flow<EUser>
}