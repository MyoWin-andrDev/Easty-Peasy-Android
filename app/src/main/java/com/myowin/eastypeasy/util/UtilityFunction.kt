package com.myowin.eastypeasy.util

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.CustomTarget
import com.bumptech.glide.request.transition.Transition

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

// For View background
fun Context.loadBackgroundFromUrl(
    imageUrl: String,
    view: View
) {
    Glide.with(this)
        .load(imageUrl)
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(object : CustomTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                view.background = resource
            }

            override fun onLoadCleared(placeholder: Drawable?) {
                view.background = placeholder
            }
        })
}