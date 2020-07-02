package com.lv.module_home

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.scopes.ActivityScoped

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