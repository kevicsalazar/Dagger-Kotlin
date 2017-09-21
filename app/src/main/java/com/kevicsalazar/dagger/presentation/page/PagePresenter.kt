package com.kevicsalazar.dagger.presentation.page

import com.kevicsalazar.dagger.data.model.Post
import com.kevicsalazar.dagger.data.repository.PostsRepository
import com.kevicsalazar.dagger.presentation.PerFragment
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
@PerFragment
class PagePresenter @Inject constructor(val view: View, val rep: PostsRepository) {

    fun loadData(type: String) {
        view.showProgress()
        rep.getPosts(type, {
            view.hideProgress()
            view.setupAdapter(it)
        }, {
            view.hideProgress()
            view.showMessage("Error", it.message ?: "Ha ocurrido un error")
        })
    }

    interface View {

        fun setupAdapter(items: List<Post>)

        fun showProgress()

        fun hideProgress()

        fun showMessage(title: String, message: String)

    }

}