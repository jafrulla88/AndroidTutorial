package com.example.androidtutorial

import com.google.gson.annotations.SerializedName

  class ParentData (){
    constructor( position:String, membersnew:Members) : this() {
      this.membersnew=membersnew
      this.position=position
      this.memberslist=memberslist
     }
      @SerializedName("first_name")
      var slug    : String?  = null
      @SerializedName("name")
      var name    : String?  = null
      @SerializedName("position")
      var position    : String?  = null
     /* @SerializedName("position")
      var members : ArrayList<Members> = arrayListOf()*/
      @SerializedName("first_name")
      var first_name    : String?  = null
      @SerializedName("last_name")
      var last_name    : String?  = null
      @SerializedName("jersey_number")
      var jersey_number    : String?  = null
      @SerializedName("headshot")
      var headshot :Headshot?=null

      var membersnew:Members?=null
      var memberslist : ArrayList<Members> = arrayListOf()



  }






