package com.example.pruebabetterfly.core.usecases

import com.example.pruebabetterfly.core.entities.EUser
import com.example.pruebabetterfly.core.repositories.RUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import java.util.*
import javax.inject.Inject

class UCUserImp @Inject constructor(private val rUser: RUser): UCUser  {

    override  fun signIn(user: String, password: String): Flow<EUser> {
        return rUser.signIn(user, password).transform { value->
            emit(value)
        }
    }

}