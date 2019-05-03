package com.github.usersearch.ui.di

import com.github.usersearch.data.api.UserSearchAPI
import com.github.usersearch.data.diModules.UserSearchAPIModule
import com.github.usersearch.ui.viewModels.MainActivityViewModel
import dagger.Module
import dagger.Provides

@Module(includes = [UserSearchAPIModule::class])
class MainActivityModule {

    @Provides
    fun providesMainActivityViewModel(userSearchAPI: UserSearchAPI): MainActivityViewModel {
        return MainActivityViewModel(userSearchAPI)
    }

}