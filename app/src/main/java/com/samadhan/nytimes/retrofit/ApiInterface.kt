package com.samadhan.nytimes.retrofit

import com.samadhan.nytimes.BuildConfig
import com.samadhan.nytimes.model.EntityArticleOutputs
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("7.json")
    fun getMostPopularArticles(@Query("api-key") apiKey: String = BuildConfig.APP_KEY): Call<EntityArticleOutputs>

}