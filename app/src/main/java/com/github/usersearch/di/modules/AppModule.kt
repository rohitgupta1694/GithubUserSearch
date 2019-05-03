package com.github.usersearch.di.modules

import android.content.Context
import com.github.usersearch.Application
import com.github.usersearch.data.diModules.RetrofitConfigModule
import dagger.Module
import dagger.Provides

@Module(includes = [RetrofitConfigModule::class])
class AppModule {

    @Provides
    fun providesContext(application: Application): Context {
        return application.applicationContext
    }
}