package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

class Headshot {

    @SerializedName("original")
    var original : String?  = null
    @SerializedName("token")
    var token : String?  = null
    @SerializedName("raw")
    var raw : String?  = null
    @SerializedName("cloudinary_token")
    var cloudinary_token    : String?  = null

}
