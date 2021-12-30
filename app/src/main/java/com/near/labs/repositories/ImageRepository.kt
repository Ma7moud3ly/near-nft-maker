package com.near.labs.repositories

import android.content.Context
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.near.labs.R

class ImageRepository {
}

@BindingAdapter("localImage")
fun localImage(view: ImageView, url: String) {
    val context: Context = view.context
    val drawable: Int =
        context.resources.getIdentifier(url, "drawable", context.packageName)

    Glide.with(view.context)
        .load(drawable)
        .error(R.drawable.near_logo)
        .into(view);
}
