package com.akmal.androidtask.utils.extensions

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(data: String?, corners: Int? = null, errorDrawable: Drawable? = null) {
    if (data == null) return

    Glide.with(context)
        .load(data)
        .transform(RoundedCorners((corners ?: 6)))
        .error(errorDrawable)
        .into(this)
}