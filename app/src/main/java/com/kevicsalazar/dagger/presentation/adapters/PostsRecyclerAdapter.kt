package com.kevicsalazar.dagger.presentation.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.kevicsalazar.dagger.R
import com.kevicsalazar.dagger.data.model.Post
import com.kevicsalazar.dagger.utils.extensions.inflate

/**
 * @author Kevin Salazar
 * @link kevicsalazar.com
 */
class PostsRecyclerAdapter(val items: List<Post>) : RecyclerView.Adapter<PostsRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.item_post))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position])

    override fun getItemCount() = items.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(item: Post) = with(itemView) {

        }

    }

}