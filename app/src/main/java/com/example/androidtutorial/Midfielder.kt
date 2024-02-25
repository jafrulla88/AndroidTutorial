package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

class Midfielder {
    @SerializedName("first_name")
    var firstName: String? = null
    @SerializedName("last_name")
    var lastName: String? = null
    @SerializedName("jersey_number")
    var jerseyNumber : String? = null
}