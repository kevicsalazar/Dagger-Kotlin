package com.kevicsalazar.dagger.presentation.page

import com.kevicsalazar.dagger.presentation.PerFragment
import dagger.Binds
import dagger.Module

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
abstract class PageFragmentModule {

    @Binds
    @PerFragment
    abstract fun provideChildView(fragment: PageFragment): PagePresenter.View

}