package com.agung.quiz.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agung.quiz.entity.Friend

class FriendDataAdapter(private val friends:ArrayList<Friend>) :RecyclerView.Adapter<FriendDataAdapter.FriendViewHolder>(){
    inner class FriendViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val textView:TextView
        init{
            textView=itemView as TextView
        }
        fun setData(friend: Friend){
            textView.text=friend.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FriendViewHolder {
        val view=TextView(parent.context)
        return FriendViewHolder(view)
    }

    override fun onBindViewHolder(holder: FriendViewHolder, position: Int) {
        holder.setData(friends[position])
    }

    override fun getItemCount(): Int {
        return friends.size
    }
}