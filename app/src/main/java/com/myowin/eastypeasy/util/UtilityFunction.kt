package com.myowin.eastypeasy.util

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions

fun Context.loadImageFromResource(
    imageResId: Int,
    imageView: ImageView
) {
    Glide.with(this)
        .load(imageResId)
        .into(imageView)
}

fun Context.loadImageFromUrl(
    imageUrl: String,
    imageView: ImageView
) {
    Glide.with(this)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageView)
}