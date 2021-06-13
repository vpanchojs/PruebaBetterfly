package com.example.pruebabetterfly.infrastructure.remote

import com.example.pruebabetterfly.core.entities.ECharacter
import com.example.pruebabetterfly.core.entities.EUser
import com.example.pruebabetterfly.core.repositories.RCharacter
import com.example.pruebabetterfly.core.repositories.RUser
import com.google.android.gms.tasks.Task
import com.google.android.gms.tasks.Tasks
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*
import javax.inject.Inject

class RUserImp @Inject constructor() : RUser {

    override fun signIn(user: String, password: String): Flow<EUser> {
        return flow {
         val resultTask = FirebaseAuth.getInstance().signInWithEmailAndPassword(user,password)
            Tasks.await(resultTask)

            if (resultTask.result!=null){
             emit(EUser(userId = resultTask.result!!.user!!.uid));
         }

     }.flowOn(Dispatchers.IO)
    }

}