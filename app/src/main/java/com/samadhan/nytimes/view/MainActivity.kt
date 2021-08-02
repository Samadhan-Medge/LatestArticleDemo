package com.samadhan.nytimes.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.samadhan.nytimes.R
import com.samadhan.nytimes.adapters.ArticleListAdapter
import com.samadhan.nytimes.databinding.ActivityMainBinding
import com.samadhan.nytimes.interfaces.IArticleSelectionListener
import com.samadhan.nytimes.model.Results
import com.samadhan.nytimes.viewmodel.ArticleViewModel

class MainActivity : AppCompatActivity() {
    lateinit var mainActivityViewModel: ArticleViewModel
    lateinit var viewBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.lifecycleOwner = this
        mainActivityViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)
        mainActivityViewModel.isLoading = true
        viewBinding.viewModel = mainActivityViewModel
        mainActivityViewModel.getArticles()!!.observe(this, Observer { serviceSetterGetter ->
            println("====hiiiiiiiii serviceSetterGetter:$serviceSetterGetter")
            mainActivityViewModel.isLoading = false
            viewBinding.recyclerViewAdapter = ArticleListAdapter(object :
                IArticleSelectionListener {
                override fun onArticleSelected(result: Results) {

                }
            }).apply { updateData(serviceSetterGetter.results) }
            mainActivityViewModel.notifyChange()
        })
//                val msg = serviceSetterGetter.message


    }
}