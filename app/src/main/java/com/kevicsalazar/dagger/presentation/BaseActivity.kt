package com.kevicsalazar.dagger.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    /**
     * The onCreate base will set the view specified in [layout]
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(getLayout())
    }

    /**
     * @return fragmentInjector
     */
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = fragmentInjector

    /**
     * @return The layout that's gonna be the activity view.
     */
    protected abstract fun getLayout(): Int

    /**
     * Detach From Presenter
     */
    abstract fun detachFromPresenter()

    /**
     * Avoid memory leaks
     */
    override fun onDestroy() {
        detachFromPresenter()
        super.onDestroy()
    }

}