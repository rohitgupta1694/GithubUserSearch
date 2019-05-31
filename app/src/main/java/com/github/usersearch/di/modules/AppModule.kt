package com.github.usersearch.di.modules

import android.content.Context
import com.github.usersearch.Application
import com.github.usersearch.data.diModules.RetrofitConfigModule
import com.github.usersearch.ui.di.MainActivityComponent
import dagger.Module
import dagger.Provides

@Module(includes = [RetrofitConfigModule::class], subcomponents = [MainActivityComponent::class])
class AppModule {

    @Provides
    fun providesContext(application: Application): Context {
        return application.applicationContext
    }
}