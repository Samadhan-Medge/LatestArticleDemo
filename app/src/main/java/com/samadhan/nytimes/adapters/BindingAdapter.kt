package com.samadhan.nytimes.adapters

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.samadhan.nytimes.model.Results
import com.squareup.picasso.Picasso

object BindingAdapter {

    @BindingAdapter
    @JvmStatic
    fun loadArticleImage(imageView: AppCompatImageView, results: Results?) {
        if (results != null) {
            if(results.media.size>0)
            {
                if(results.media[0].mediaMetadata.size>0)
                {
                    Picasso.get().load(results.media[0].mediaMetadata[0].url).into(imageView)
                }
            }
        }
    }
}