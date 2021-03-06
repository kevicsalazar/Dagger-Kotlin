package com.kevicsalazar.dagger.data


import com.kevicsalazar.dagger.data.repository.PostsRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Module
class DataModule {

    @Provides
    fun provideRetrofit() = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8082/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()!!

    @Provides
    fun providePostsRepository(retrofit: Retrofit) = retrofit.create(PostsRepository.Service::class.java)!!

}
