package com.agung.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.agung.quiz.adapter.MainDataAdapater
import com.agung.quiz.databinding.ActivityMainBinding
import com.agung.quiz.entity.User
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import java.io.InputStreamReader


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val users=ArrayList<User>()
    private val mainDataAdapater=MainDataAdapater(users)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val layoutManager=LinearLayoutManager(this@MainActivity)
        binding.mainRV.adapter=mainDataAdapater
        binding.mainRV.layoutManager=layoutManager
        mainDataAdapater.setMainDataListener(object :MainDataAdapater.MainDataListener{
            override fun mainDataClicked(user: User) {
                Toast.makeText(this@MainActivity,user.name,Toast.LENGTH_SHORT).show()
                val intent= Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra("user",user)
                intent.putExtra("friends",user.friends)
                startActivity(intent)
            }
        })
    }

    override fun onStart() {
        super.onStart()
        if (!intent.getStringExtra("name").isNullOrEmpty()){
            val builder=AlertDialog.Builder(this@MainActivity)
            builder.setMessage(intent.getStringExtra("name"))
            val alertDialog=builder.create()
            alertDialog.show()
        }
        fetchData()
    }
    private fun fetchData(){
        val inputStream=assets.open("data.json")
        val reader= JsonReader(InputStreamReader(inputStream,"UTF-8"))
        val gson=Gson()
        val data=gson.fromJson<Array<User>>(reader,Array<User>::class.java)
        users.clear()
        users.addAll(data)
        mainDataAdapater.notifyItemChanged(0)
    }
}