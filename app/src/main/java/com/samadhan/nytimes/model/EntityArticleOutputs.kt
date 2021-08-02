package com.samadhan.nytimes.model

import com.google.gson.annotations.SerializedName

data class EntityArticleOutputs(
    @SerializedName("status") val status: String,
    @SerializedName("copyright") val copyright: String,
    @SerializedName("num_results") val num_results: Long,
    @SerializedName("results") val results: List<Results>
)
