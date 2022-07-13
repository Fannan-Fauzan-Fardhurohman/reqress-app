package com.fanxan.reqresapp.repository

import com.fanxan.reqresapp.data.User
import com.fanxan.reqresapp.event.StateEventManager

interface UserRepository {
    val userStateEventManager:StateEventManager<List<User>>

    suspend fun getUsers(page:Int = 1)
}