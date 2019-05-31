package com.github.usersearch.di.modules

import android.app.Activity
import com.github.usersearch.ui.activities.MainActivity
import com.github.usersearch.ui.di.MainActivityComponent
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ActivityBuilder {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    abstract fun bindWebViewActivity(builder: MainActivityComponent.Builder): AndroidInjector.Factory<out Activity>

}