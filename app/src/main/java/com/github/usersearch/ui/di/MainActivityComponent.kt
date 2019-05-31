package com.github.usersearch.ui.di

import com.github.usersearch.ui.activities.MainActivity
import com.github.usersearch.ui.viewModels.MainActivityViewModel
import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(modules = [MainActivityModule::class])
interface MainActivityComponent : AndroidInjector<MainActivity> {

    fun getMainActivityViewModel(): MainActivityViewModel

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()

}