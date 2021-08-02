package com.samadhan.nytimes.interfaces

import com.samadhan.nytimes.model.Results

interface IArticleSelectionListener {
    fun onArticleSelected(result: Results)
}