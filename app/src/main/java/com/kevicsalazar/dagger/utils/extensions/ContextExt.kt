package com.kevicsalazar.dagger.utils.extensions

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import com.kevicsalazar.dagger.R

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun Context.colorRes(colorResId: Int) = ContextCompat.getColor(this, colorResId)

fun Context.colorStateListRes(colorResId: Int) = ContextCompat.getColorStateList(this, colorResId)!!

fun Context.alert(title: String, message: String, init: (AlertDialog.Builder.() -> Unit)? = null) = AlertDialog.Builder(this).apply {
    setTitle(title)
    setMessage(message)
    setPositiveButton("OK", { dialog, w -> dialog.dismiss() })
    init?.let { init() }
}