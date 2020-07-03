package com.example.module_home

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class UserAModule {
    @A
    @Binds
    abstract fun getUserA(userImpl: UserAImpl): User
}

@Module
@InstallIn(ApplicationComponent::class)
abstract class UserBModule {

    @B
    @Binds
    abstract fun getUserB(userImpl: UserBImpl): User
}