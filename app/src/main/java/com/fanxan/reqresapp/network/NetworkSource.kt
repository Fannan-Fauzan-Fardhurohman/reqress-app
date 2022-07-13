package com.fanxan.reqresapp.network

import com.fanxan.reqresapp.FlowState
import com.fanxan.reqresapp.data.Mapper
import com.fanxan.reqresapp.data.User
import com.fanxan.reqresapp.utils.asFlowStateEvent
import org.koin.core.annotation.Single

@Single
class NetworkSource(private val webServicesProvider: WebServicesProvider) {

    suspend fun getList(page: Int): FlowState<List<User>> {
        return webServicesProvider.get().getList(page).asFlowStateEvent {
            Mapper.mapUserResponse(it)
        }
    }

//    suspend fun getDetails(id: Int): FlowState<List<User>> {
//        return webServicesProvider.get().getList(1).asFlowStateEvent {
//            Mapper.mapUserResponse(it)
//        }
//    }
}