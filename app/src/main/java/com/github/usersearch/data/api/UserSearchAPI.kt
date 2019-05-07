package com.github.usersearch.data.api

import com.github.usersearch.data.models.GithubUserResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UserSearchAPI {

    @Headers("Accept: application/vnd.github.v3+json")
    @GET("search/users")
    fun getUsers(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20
    ): Single<GithubUserResponse>

}