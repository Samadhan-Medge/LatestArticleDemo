package com.samadhan.nytimes.viewmodel

import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.samadhan.nytimes.model.EntityArticleOutputs
import com.samadhan.nytimes.repository.ArticleRepository

class ArticleViewModel : ViewModel(), Observable {

    var servicesLiveData: MutableLiveData<EntityArticleOutputs>? = null
    private val callbacks: PropertyChangeRegistry = PropertyChangeRegistry()

    var isLoading: Boolean = true

    fun getArticles(): LiveData<EntityArticleOutputs>? {
        servicesLiveData = ArticleRepository.getServicesApiCall()
        return servicesLiveData
    }



    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    /**
     * Notifies observers that all properties of this instance have changed.
     */
    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

}