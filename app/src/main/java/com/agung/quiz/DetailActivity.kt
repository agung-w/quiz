package com.agung.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.agung.quiz.adapter.FriendDataAdapter
import com.agung.quiz.databinding.ActivityDetailBinding
import com.agung.quiz.entity.Friend
import com.agung.quiz.entity.User

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun onStart() {
        super.onStart()
        val user=intent.getParcelableExtra<User>("user")!!
        val layoutManager= LinearLayoutManager(this@DetailActivity)
        binding.friendRV.adapter=FriendDataAdapter(user.friends)
        binding.friendRV.layoutManager=layoutManager
        binding.detailNameTV.text="${user.name} (${user.age})"
        binding.bioTV.text=user.about
        binding.phoneTV.text=user.phone
        binding.addressTV.text=user.address
    }

}