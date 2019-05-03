package com.github.usersearch.data.api

import android.database.Observable
import com.rohit.githubusersearchmvi.data.models.GithubUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface UserSearchAPI {

    @GET("search/users")
    fun getUsers(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Observable<GithubUserResponse>

}