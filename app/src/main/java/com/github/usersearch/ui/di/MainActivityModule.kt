package com.github.usersearch.ui.di

import com.github.usersearch.data.diModules.UserSearchAPIModule
import com.github.usersearch.ui.viewModels.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [UserSearchAPIModule::class])
class MainActivityModule