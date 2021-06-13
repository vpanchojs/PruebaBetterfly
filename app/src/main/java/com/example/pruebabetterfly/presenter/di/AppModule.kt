package com.example.pruebabetterfly.presenter.di

import android.content.Context
import com.example.pruebabetterfly.core.repositories.RCharacter
import com.example.pruebabetterfly.core.repositories.RUser
import com.example.pruebabetterfly.core.usecases.UCCharacter
import com.example.pruebabetterfly.core.usecases.UCCharacterImp
import com.example.pruebabetterfly.core.usecases.UCUser
import com.example.pruebabetterfly.core.usecases.UCUserImp
import com.example.pruebabetterfly.infrastructure.remote.ApiService
import com.example.pruebabetterfly.infrastructure.remote.ApiServiceImp
import com.example.pruebabetterfly.infrastructure.remote.RCharacterImp
import com.example.pruebabetterfly.infrastructure.remote.RUserImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providerApiService(@ApplicationContext context: Context,apiServiceImp: ApiServiceImp): ApiService {
        return apiServiceImp.build(ApiService::class.java,context,"https://rickandmortyapi.com/api/")
    }

    @Provides
    fun providerUCCharacter(rCharacter: RCharacter): UCCharacter {
        return UCCharacterImp(rCharacter)
    }
    @Provides
    fun providerRCharacter(request: ApiService): RCharacter {
        return RCharacterImp(request)
    }

    @Provides
    fun providerUCUser(rUser: RUser): UCUser {
        return UCUserImp(rUser)
    }
    @Provides
    fun providerRUser(request: ApiService): RUser {
        return RUserImp()
    }
}