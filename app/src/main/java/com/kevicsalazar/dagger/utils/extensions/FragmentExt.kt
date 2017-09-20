package com.kevicsalazar.dagger.utils.extensions

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import org.jetbrains.anko.bundleOf

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */

fun Fragment.replaceChildFragment(@IdRes containerViewId: Int, fragment: Fragment) {
    childFragmentManager.beginTransaction()
            .replace(containerViewId, fragment)
            .commit()
}

fun <T : Fragment> T.withArguments(vararg params: Pair<String, Any>): T {
    arguments = bundleOf(*params)
    return this
}
