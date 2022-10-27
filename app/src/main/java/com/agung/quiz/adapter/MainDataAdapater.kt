package com.agung.quiz.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.agung.quiz.R
import com.agung.quiz.databinding.MainCardBinding
import com.agung.quiz.entity.User
import com.bumptech.glide.Glide

class MainDataAdapater(private val users:ArrayList<User>): RecyclerView.Adapter<MainDataAdapater.MainViewHolder>() {
    private lateinit var mainDataListener: MainDataListener
    inner class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val binding:MainCardBinding=MainCardBinding.bind(itemView)
        fun setData(user: User){
            binding.nameTV.text=user.name
            binding.idTV.text=user.id
            binding.companyTV.text=user.company
            binding.emailTV.text=user.email
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.main_card,parent,false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(users[position])
        holder.itemView.setOnClickListener{
            mainDataListener.mainDataClicked(users[position])
        }
    }

    override fun getItemCount(): Int {
        return users.size
    }
    fun setMainDataListener(mainDataListener: MainDataListener){
        this.mainDataListener=mainDataListener
    }
    interface MainDataListener{
        fun mainDataClicked(user:User)
    }
}