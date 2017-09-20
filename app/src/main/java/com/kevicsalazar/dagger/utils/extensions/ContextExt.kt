package com.kevicsalazar.dagger.utils.extensions

import android.content.Context
import android.support.v4.content.ContextCompat

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun Context.colorRes(colorResId: Int) = ContextCompat.getColor(this, colorResId)

fun Context.colorStateListRes(colorResId: Int) = ContextCompat.getColorStateList(this, colorResId)!!
