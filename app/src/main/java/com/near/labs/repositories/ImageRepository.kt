package com.near.labs.repositories

import android.content.Context
import android.net.Uri
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.near.labs.R


@BindingAdapter("resourceImage")
fun resourceImage(view: ImageView, path: String?) {
    val context: Context = view.context
    path?.let {
        if (path.isEmpty()) return
        val img =
            context.resources.getIdentifier(path, "drawable", context.packageName)
        Glide.with(view.context)
            .load(img)
            .error(R.drawable.art1)
            .into(view);
    }
}

fun localImage(view: ImageView, uri: Uri?) {
    uri.let {
        Glide.with(view.context)
            .load(uri)
            .error(R.drawable.art1)
            .into(view);
    }
}
