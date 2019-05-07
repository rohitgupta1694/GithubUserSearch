package com.github.usersearch.data.models

import com.google.gson.annotations.SerializedName

data class GithubUserResponse(

    @SerializedName("total_count")
    val totalCount: Int? = null,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @SerializedName("items")
    val user: List<UserItem>
)