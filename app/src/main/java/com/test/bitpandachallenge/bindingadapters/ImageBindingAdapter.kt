package com.test.bitpandachallenge.bindingadapters

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.test.bitpandachallenge.R

object ImageBindingAdapter {

    // Custom binding logic to set image to the image view
    @BindingAdapter("imageUrl")
    @JvmStatic
    fun bindImage(imageView: ImageView, imageUrl: String?) {

        val imageUri = imageUrl?.toUri()

        Glide.with(imageView.context)
            .load(imageUri)
            .diskCacheStrategy(DiskCacheStrategy.DATA)
            .placeholder(R.drawable.animation_loading)
            .error(R.drawable.ic_error)
            .into(imageView)

    }
}