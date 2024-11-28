package com.example.testknovator.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.testknovator.R
import com.example.testknovator.ViewModel.PostViewModel

class PostDetailActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()

    companion object {
        private const val POST_ID = "post_id"
        fun start(context: Context, postId: Int) {
            val intent = Intent(context, PostDetailActivity::class.java)
            intent.putExtra(POST_ID, postId)
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post_detail)

        val titleTextView: TextView = findViewById(R.id.postTitle)
        val bodyTextView: TextView = findViewById(R.id.postBody)

        val postId = intent.getIntExtra(POST_ID, -1)
        postViewModel.fetchPostDetail(postId)

        postViewModel.selectedPost.observe(this, Observer { post ->
            post?.let {
                titleTextView.text = post.title
                bodyTextView.text = post.body
            }
        })
    }
}
