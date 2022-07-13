package com.fanxan.reqresapp.repository

import com.fanxan.reqresapp.data.User
import com.fanxan.reqresapp.event.StateEventManager
import com.fanxan.reqresapp.network.NetworkSource
import com.fanxan.reqresapp.utils.default
import org.koin.core.annotation.Single

@Single
class MainRepositoryImpl(
    private val networkSource: NetworkSource
) : UserRepository {

    private val _userStateEventManager = default<List<User>>()
    override val userStateEventManager: StateEventManager<List<User>>
        get() = _userStateEventManager

    override suspend fun getUsers(page: Int) {
        networkSource
            .getList(page)
            .collect(_userStateEventManager)
    }
}