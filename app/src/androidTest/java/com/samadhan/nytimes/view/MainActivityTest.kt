package com.samadhan.nytimes.view

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.samadhan.nytimes.databinding.ActivityMainBinding
import com.samadhan.nytimes.viewmodel.ArticleViewModel
import junit.framework.TestCase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
class MainActivityTest : TestCase() {
    private lateinit var mainActivityViewModel: ArticleViewModel
    private lateinit var viewBinding: ActivityMainBinding

    @Before
    public override fun setUp() {
        super.setUp()
        val viewModelStoreOwner: ViewModelStoreOwner = Mockito.mock(ViewModelStoreOwner::class.java)
        mainActivityViewModel = ViewModelProvider(viewModelStoreOwner).get(ArticleViewModel::class.java)
    }

    @Test
    public fun testApiFetchDataSuccess() {
        val lifecycleOwner: LifecycleOwner = Mockito.mock(LifecycleOwner::class.java)
        mainActivityViewModel.getArticles()!!.observe(lifecycleOwner, { serviceSetterGetter ->

        }
        )
    }
}