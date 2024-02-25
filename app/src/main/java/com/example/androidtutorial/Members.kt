package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

class Members() {
    constructor( first_name:String, last_name:String,jersey_number:String,original:String) : this() {
        this.first_name=first_name
        this.last_name=last_name
        this.jersey_number=jersey_number
        this.original=original
     }
    @SerializedName("name")
    var name : String? = null
    @SerializedName("slug")
    var slug : String? = null
    @SerializedName("first_name")
    var first_name : String? = null
    @SerializedName("last_name")
    var last_name : String? = null
    @SerializedName("jersey_number")
    var jersey_number : String? = null
    var original : String? = null
    @SerializedName("headshot")
    var headshot : Headshot? = null
    var memberslist : ArrayList<Members> = arrayListOf()


}