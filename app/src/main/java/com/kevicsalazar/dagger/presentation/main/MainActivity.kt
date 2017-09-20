package com.kevicsalazar.dagger.presentation.main


import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import com.kevicsalazar.dagger.R
import com.kevicsalazar.dagger.presentation.BaseActivity
import com.kevicsalazar.dagger.presentation.page.PageFragment
import com.kevicsalazar.dagger.utils.extensions.*
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainPresenter.View {

    @Inject lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(toolbar)

        presenter.prepareToShow(R.id.action_page_1)
        bottomNavigation.setOnNavigationItemSelectedListener {
            presenter.prepareToShow(it.itemId)
        }
    }

    override fun getLayout() = R.layout.activity_main

    override fun detachFromPresenter() {

    }

    override fun showFragmentView(type: String) {
        replaceFragment(R.id.layoutContent, PageFragment().withArguments("type" to type))
    }

    override fun setupColor(drawableResId: Int) {
        bottomNavigation.itemIconTintList = colorStateListRes(drawableResId)
        bottomNavigation.itemTextColor = colorStateListRes(drawableResId)
    }

    override fun startColorTransition(colorResId: Int) {
        val currentColor = (toolbar.background as ColorDrawable).color
        val anim = ValueAnimator.ofObject(ArgbEvaluator(), currentColor, colorRes(colorResId))
        anim.duration = 250
        anim.addUpdateListener {
            val color = it.animatedValue as MaterialColor
            setStatusBarColor(color.palette().C700)
            toolbar.setBackgroundColor(color)
        }
        anim.start()
    }

}
