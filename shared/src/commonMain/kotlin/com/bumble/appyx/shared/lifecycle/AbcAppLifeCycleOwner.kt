package com.bumble.appyx.shared.lifecycle

import com.arkivanov.essenty.lifecycle.Lifecycle
import com.arkivanov.essenty.lifecycle.LifecycleOwner


class AbcAppLifeCycleOwner : LifecycleOwner {
    override val lifecycle: Lifecycle = AbcAppLifeCycle()

    val state: Lifecycle.State by lifecycle::state

}