package com.example.testknovator.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testknovator.Model.Post
import com.example.testknovator.R

class PostAdapter(private val onItemClick: (Post) -> Unit) : RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    private var posts: List<Post> = listOf()

    inner class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.postTitle)

        fun bind(post: Post) {
            title.text = post.title
            itemView.setOnClickListener { onItemClick(post) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_post, parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.bind(posts[position])
    }

    override fun getItemCount(): Int = posts.size

    fun submitList(newPosts: List<Post>) {
        posts = newPosts
        notifyDataSetChanged()
    }
}
