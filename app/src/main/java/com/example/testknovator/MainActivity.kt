package com.example.testknovator

import android.os.Bundle
import androidx.activity.viewModels

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testknovator.Activity.PostDetailActivity
import com.example.testknovator.Adapter.PostAdapter
import com.example.testknovator.ViewModel.PostViewModel


class MainActivity : AppCompatActivity() {

    private val postViewModel: PostViewModel by viewModels()
    private val postAdapter = PostAdapter { post ->
        // Handle item click, navigate to detail activity
        PostDetailActivity.start(this, post.id)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)


        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = postAdapter

        postViewModel.fetchPosts()

        postViewModel.posts.observe(this, Observer { posts ->
            posts?.let {
                postAdapter.submitList(it)
            }
        })
    }
}
