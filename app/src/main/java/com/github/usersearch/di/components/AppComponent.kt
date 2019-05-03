package com.github.usersearch.di.components

import com.github.usersearch.Application
import com.github.usersearch.di.modules.ActivityBuilder
import com.github.usersearch.di.modules.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ActivityBuilder::class, AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<Application> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<Application>()
}