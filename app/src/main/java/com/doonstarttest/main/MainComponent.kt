package com.doonstarttest.main

import android.util.Log
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.lifecycle.doOnStart

class MainComponent(private val componentContext: ComponentContext) : ComponentContext by componentContext {
    init {
        lifecycle.doOnStart {
            Log.d("LIFECYCLE", "doOnStart")
        }
    }
}