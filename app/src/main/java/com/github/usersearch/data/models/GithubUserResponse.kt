package com.rohit.githubusersearchmvi.data.models

import com.google.gson.annotations.SerializedName

data class GithubUserResponse(

    @SerializedName("total_count")
    val totalCount: Int? = null,

    @SerializedName("incomplete_results")
    val incompleteResults: Boolean? = null,

    @SerializedName("user")
    val user: List<UserItem?>? = null
)