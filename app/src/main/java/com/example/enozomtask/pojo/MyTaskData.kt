package com.example.enozomtask.pojo

import com.google.gson.annotations.SerializedName


data class MyTaskData (

  @SerializedName("Indexes" ) var Indexes : String? = null,
  @SerializedName("Text"    ) var Text    : String? = null

)