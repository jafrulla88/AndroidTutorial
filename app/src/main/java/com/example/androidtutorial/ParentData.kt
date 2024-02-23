package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

class ParentData {
    @SerializedName("slug")
    var slug    : String?  = null
    @SerializedName("name")
    var name    : String?  = null
    @SerializedName("position")
    var position    : String?  = null
    @SerializedName("position")
    var members : ArrayList<Members> = arrayListOf()


}