package com.fanxan.reqresapp.data


import com.google.gson.annotations.SerializedName

data class SupportX(
    @SerializedName("text")
    val text: String,
    @SerializedName("url")
    val url: String
)