package com.kevicsalazar.dagger

import com.kevicsalazar.dagger.data.DataModule
import com.kevicsalazar.dagger.presentation.PerActivity
import com.kevicsalazar.dagger.presentation.main.MainActivity
import com.kevicsalazar.dagger.presentation.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module(includes = arrayOf(
        DataModule::class,
        AndroidSupportInjectionModule::class))
abstract class AppModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun contributeMainActivity(): MainActivity

}