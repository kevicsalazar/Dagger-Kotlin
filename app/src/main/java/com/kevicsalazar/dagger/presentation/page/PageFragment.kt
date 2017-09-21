package com.kevicsalazar.dagger.presentation.page

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.kevicsalazar.dagger.R
import com.kevicsalazar.dagger.data.model.Post
import com.kevicsalazar.dagger.presentation.BaseFragment
import com.kevicsalazar.dagger.presentation.adapters.PostsRecyclerAdapter
import com.kevicsalazar.dagger.utils.extensions.alert
import kotlinx.android.synthetic.main.fragment_page.*
import javax.inject.Inject

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PageFragment : BaseFragment(), PagePresenter.View {

    @Inject lateinit var presenter: PagePresenter

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.loadData(arguments.getString("type"))
    }

    override fun getLayout() = R.layout.fragment_page

    override fun detachFromPresenter() {

    }

    override fun setupAdapter(items: List<Post>) {
        val adapter = PostsRecyclerAdapter(items)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    override fun showProgress() {
        swipeRefresh.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        swipeRefresh.visibility = View.GONE
    }

    override fun showMessage(title: String, message: String) {
        alert(title, message).show()
    }

}