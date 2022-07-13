package com.fanxan.reqresapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fanxan.reqresapp.data.User
import com.fanxan.reqresapp.event.StateEventSubscriber
import com.fanxan.reqresapp.repository.UserRepository
import com.fanxan.reqresapp.utils.convertEventToSubscriber
import kotlinx.coroutines.launch
import org.koin.core.annotation.Scope

@Scope(MainActivity::class)
class MainViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val userManager = userRepository.userStateEventManager

    private val userScope = userManager.createScope(viewModelScope)

    fun subscribeUser(subscriber: StateEventSubscriber<List<User>>) {
        convertEventToSubscriber(userManager, subscriber)
    }

    fun getUsers(page: Int) = userScope.launch {
        userRepository.getUsers(page)
    }
}