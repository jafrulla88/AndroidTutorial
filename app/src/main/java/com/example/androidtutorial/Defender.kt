package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

class Defender {
    @SerializedName("first_name")
    var first_name: String? = null
    @SerializedName("last_name")
    var last_name: String? = null
    @SerializedName("jersey_number")
    var jersey_number : String? = null
}