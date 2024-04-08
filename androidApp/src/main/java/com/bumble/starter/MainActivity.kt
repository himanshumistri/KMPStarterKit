package com.bumble.starter

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import co.touchlab.kermit.Logger
import com.arkivanov.essenty.lifecycle.LifecycleOwner
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.asEssentyLifecycle
import com.arkivanov.essenty.lifecycle.essentyLifecycle
import com.bumble.appyx.navigation.integration.NodeActivity
import com.bumble.appyx.navigation.integration.NodeHost
import com.bumble.appyx.navigation.platform.AndroidLifecycle
import com.bumble.appyx.shared.root.RootNode
import com.bumble.appyx.shared.ui.theme.AppyxStarterKitTheme

class MainActivity : NodeActivity(), androidx.lifecycle.LifecycleOwner {

    private lateinit var lifecycleRegistry: LifecycleRegistry

    fun getLifecycle(): LifecycleRegistry {
        return lifecycleRegistry
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        essentyLifecycle()
        lifecycleRegistry = LifecycleRegistry()
        lifecycleRegistry.onCreate()
           //markState(Lifecycle.State.CREATED)
        setContent {
            AppyxStarterKitTheme {
                NodeHost(
                    lifecycle = AndroidLifecycle(LocalLifecycleOwner.current.lifecycle),
                    integrationPoint = appyxV2IntegrationPoint,
                ) {
                    RootNode(buildContext = it)
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()
        lifecycleRegistry.onStart()
    }
    override fun onStop() {
        super.onStop()
        lifecycleRegistry.onStop()
        Logger.i (messageString = "Home Screen onStop", tag = "Home")
    }


    override fun onResume() {
        super.onResume()
        lifecycleRegistry.onResume()
        Logger.i (messageString = "Home Screen onResume", tag = "Home")
    }
    override fun onPause() {
        super.onPause()
        lifecycleRegistry.onPause()
        Logger.i (messageString = "Home Screen onPause", tag = "Home")
    }

    override fun onDestroy() {
        super.onDestroy()
        Logger.i (messageString = "Home Screen onDestroy", tag = "Home")
    }
}
