package com.bumble.appyx.shared.lifecycle

import com.arkivanov.essenty.lifecycle.Lifecycle

class AbcAppLifeCycle : Lifecycle {

    private var callbacks: MutableSet<Lifecycle.Callbacks> = HashSet()

    override var state: Lifecycle.State = Lifecycle.State.INITIALIZED

    override fun subscribe(callbacks: Lifecycle.Callbacks) {
        this.callbacks += callbacks
    }

    override fun unsubscribe(callbacks: Lifecycle.Callbacks) {
        this.callbacks -= callbacks
    }

}