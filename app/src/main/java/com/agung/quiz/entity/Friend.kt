package com.agung.quiz.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Friend (val id:Int,val name:String):Parcelable{
    override fun toString(): String {
        return "$id $name"
    }
}
