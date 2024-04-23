package com.doonstarttest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.defaultComponentContext
import com.doonstarttest.root.RootComponent
import com.doonstarttest.root.RootContent
import com.doonstarttest.ui.theme.DoOnStartTestTheme

class MainActivity : ComponentActivity() {

    private val root by lazy { RootComponent(defaultComponentContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DoOnStartTestTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    RootContent(component = root)
                }
            }
        }
    }
}
