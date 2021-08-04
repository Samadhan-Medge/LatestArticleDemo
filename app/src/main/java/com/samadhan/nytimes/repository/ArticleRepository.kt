package com.samadhan.nytimes.repository

import androidx.lifecycle.MutableLiveData
import com.samadhan.nytimes.BuildConfig
import com.samadhan.nytimes.model.EntityArticleOutputs
import com.samadhan.nytimes.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object ArticleRepository {
    val serviceSetterGetter = MutableLiveData<EntityArticleOutputs>()
    fun getServicesApiCall(): MutableLiveData<EntityArticleOutputs> {
        val call = RetrofitClient.apiInterface.getMostPopularArticles(BuildConfig.APP_KEY)
        call.enqueue(object : Callback<EntityArticleOutputs> {
            override fun onFailure(call: Call<EntityArticleOutputs>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<EntityArticleOutputs>,
                response: Response<EntityArticleOutputs>
            ) {
                serviceSetterGetter.value =
                    response.body()//ObjectConvertor.convertStringToObject(response.body().toString(), EntityArticleOutputs::class.java)
            }
        })
        return serviceSetterGetter
    }
}