package com.fanxan.reqresapp.data


import com.google.gson.annotations.SerializedName

data class UserDetailResponse(
    @SerializedName("data")
    val `data`: DataX,
    @SerializedName("support")
    val support: SupportX
)