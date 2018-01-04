package com.example.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)
        val textView: TextView = findViewById(R.id.textview_post)
        val posts = retrofit.create(RestApi::class.java).getPosts()
        posts.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                //Set the response to the textview
                textView.setText(response.body()!![0].body)

            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                //Set the error to the textview
                textView.setText(t.toString())
            }
        })
    }
}
