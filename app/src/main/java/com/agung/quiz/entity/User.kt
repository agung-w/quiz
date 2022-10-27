package com.agung.quiz.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class User(
    @SerializedName("_id") val id:String,
    val name:String,
    val company:String,
    val email:String,
    val picture:String,
    val friends:ArrayList<Friend>,
    val address:String,
    val phone:String,
    val age:Int,
    val about:String
) : Parcelable