package com.github.usersearch.ui.viewModels

import com.github.usersearch.data.api.UserSearchAPI
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(val userSearchAPI: UserSearchAPI) {

    fun getUserAPI(): String = userSearchAPI.toString()

}