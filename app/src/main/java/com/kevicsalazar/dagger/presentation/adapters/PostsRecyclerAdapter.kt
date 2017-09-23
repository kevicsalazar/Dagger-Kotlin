package com.kevicsalazar.dagger.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.kevicsalazar.dagger.R
import com.kevicsalazar.dagger.data.model.Post
import com.kevicsalazar.dagger.utils.extensions.inflate
import com.kevicsalazar.dagger.utils.extensions.load
import kotlinx.android.synthetic.main.item_post.view.*

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PostsRecyclerAdapter : RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder>() {

    private val posts = mutableListOf<Post>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_post))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(posts[position])

    override fun getItemCount() = posts.size

    fun addAll(items: List<Post>) {
        posts.clear()
        posts.addAll(items)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Post) = with(itemView) {
            tvName.text = item.name
            tvDescription.text = item.description
            ivPreview.load(item.previewUrl)
        }

    }

}