package com.fanxan.reqresapp

import android.app.Application
import com.fanxan.reqresapp.di.MainModule
import com.fanxan.reqresapp.event.StateEvent
import kotlinx.coroutines.flow.Flow
import org.koin.core.context.startKoin
import org.koin.ksp.generated.module
typealias FlowState<T> = Flow<StateEvent<T>>

class MainApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(MainModule().module)
        }
    }

}