package com.doonstarttest.root

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.doonstarttest.main.MainComponent
import kotlinx.parcelize.Parcelize

class RootComponent(private val componentContext: ComponentContext) : ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    val stack =
        childStack(
            source = navigation,
            initialConfiguration = Config.Main,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): RootChild {
        return when (config) {
            Config.Main -> RootChild.Main(MainComponent(componentContext))
        }
    }

    sealed class Config : Parcelable {
        @Parcelize
        data object Main : Config()
    }

    sealed class RootChild {
        data class Main(val mainComponent: MainComponent) : RootChild()
    }
}