package com.kevicsalazar.dagger.presentation.main

import com.kevicsalazar.dagger.presentation.PerActivity
import com.kevicsalazar.dagger.presentation.PerFragment
import com.kevicsalazar.dagger.presentation.page.PageFragment
import com.kevicsalazar.dagger.presentation.page.PageFragmentModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun provideMainView(activity: MainActivity): MainPresenter.View

    @PerFragment
    @ContributesAndroidInjector(modules = arrayOf(PageFragmentModule::class))
    abstract fun contributePageFragment(): PageFragment

}