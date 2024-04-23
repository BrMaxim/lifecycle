package com.doonstarttest.root

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.doonstarttest.main.MainContent

@Composable
fun RootContent(component: RootComponent) {
    Children(
        stack = component.stack,
        modifier = Modifier.fillMaxSize(),
        animation = stackAnimation(fade() + scale())
    ) {
        when (val child = it.instance) {
            is RootComponent.RootChild.Main -> MainContent(component = child.mainComponent)
        }
    }
}