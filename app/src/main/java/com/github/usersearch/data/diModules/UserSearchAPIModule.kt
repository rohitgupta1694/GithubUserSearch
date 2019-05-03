package com.github.usersearch.data.diModules

import com.github.usersearch.data.api.UserSearchAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class UserSearchAPIModule {

    @Provides
    fun provideUserSearchApi(retrofit: Retrofit): UserSearchAPI =
        retrofit.create(UserSearchAPI::class.java)

}