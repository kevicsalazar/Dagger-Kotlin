package com.kevicsalazar.dagger.utils.extensions

import android.os.Build
import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by Kevin Salazar
 */

fun AppCompatActivity.replaceFragment(@IdRes containerViewId: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
}

fun AppCompatActivity.setStatusBarColor(color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) window.statusBarColor = color
}