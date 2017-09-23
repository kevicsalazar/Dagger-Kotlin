package com.kevicsalazar.dagger.data.repository

import com.kevicsalazar.dagger.data.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import javax.inject.Inject
import javax.inject.Singleton

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@Singleton
class PostsRepository @Inject constructor(val service: Service) {

    fun getPosts(type: String, success: (List<Post>) -> Unit, error: (Throwable) -> Unit) {
        service.request(type).enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>) {
                if (response.isSuccessful) {
                    success(response.body() ?: listOf())
                } else {
                    error(Throwable(response.message()))
                }
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable) {
                error(t)
                t.printStackTrace()
            }
        })
    }

    interface Service {

        @GET("{type}")
        fun request(@Path("type") type: String): Call<List<Post>>

    }

}