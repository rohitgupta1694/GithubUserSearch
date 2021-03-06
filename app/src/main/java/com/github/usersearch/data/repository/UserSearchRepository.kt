package com.github.usersearch.data.repository

import com.github.usersearch.data.api.UserSearchAPI
import com.github.usersearch.data.models.GithubUserResponse
import com.github.usersearch.data.models.UserItem
import io.reactivex.Single
import javax.inject.Inject

class UserSearchRepository @Inject constructor(val userSearchAPI: UserSearchAPI) {

    fun searchUser(query: String): Single<List<UserItem>> {
        return userSearchAPI.getUsers(query).map { t: GithubUserResponse -> t.user }
    }

}