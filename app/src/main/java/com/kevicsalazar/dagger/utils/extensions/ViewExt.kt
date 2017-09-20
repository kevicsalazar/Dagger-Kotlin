package com.kevicsalazar.dagger.utils.extensions


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun ImageView.load(url: String?) {
    Picasso.with(context).load(url).into(this)
}

fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)!!