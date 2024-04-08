package com.bumble.appyx.shared.child

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.touchlab.kermit.Logger
import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import com.arkivanov.essenty.lifecycle.subscribe
import com.bumble.appyx.navigation.modality.BuildContext
import com.bumble.appyx.navigation.node.Node
import com.bumble.appyx.shared.lifecycle.AbcAppLifeCycleOwner
import com.bumble.appyx.shared.ui.theme.sizzling_red

class ChildNode1(buildContext: BuildContext) : Node(buildContext) {

    val lifecycleRegistry = LifecycleRegistry()
    private var mAbcAppLifeCycleOwner: AbcAppLifeCycleOwner = AbcAppLifeCycleOwner()
    init {
        lifecycleRegistry.subscribe (onPause = {
            Logger.i (messageString = "Home Screen LaunchedEffect onPause new", tag = "Home")
        }, onStop = {
            Logger.i (messageString = "Home Screen LaunchedEffect onStop new", tag = "Home")
        })
        Logger.i (messageString = "Home Screen LaunchedEffect Register", tag = "Home")
    }

    @Composable
    override fun View(modifier: Modifier) {

        LaunchedEffect("LifeCycle"){

            val callbacks: Lifecycle.Callbacks =
                object : Lifecycle.Callbacks {
                    override fun onCreate() {

                    }

                    override fun onStart() {

                    }

                    override fun onResume() {

                    }

                    override fun onPause() {
                        Logger.i (messageString = "Home Screen LaunchedEffect onPause", tag = "Home")
                    }

                    override fun onStop() {
                        Logger.i (messageString = "Home Screen LaunchedEffect onStop", tag = "Home")
                    }

                    override fun onDestroy() {

                    }
                }

            mAbcAppLifeCycleOwner.lifecycle.subscribe(callbacks)
            Logger.i (messageString = "Home Screen LaunchedEffect Register Main", tag = "Home")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier
                .background(color = sizzling_red)
                .fillMaxSize()
        ) {
            Text(
                text = "This is Child 1",
                modifier = Modifier
                    .padding(vertical = 8.dp)
            )
        }
    }
}
