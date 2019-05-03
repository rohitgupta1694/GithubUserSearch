package com.github.usersearch.di.modules

import dagger.android.ContributesAndroidInjector
import com.github.usersearch.ui.activities.MainActivity
import com.github.usersearch.ui.di.MainActivityModule
import dagger.Module

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}