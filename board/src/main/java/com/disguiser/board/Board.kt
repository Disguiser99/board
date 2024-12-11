package com.disguiser.board

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

public abstract class Board {

    var inited: Boolean = false

    lateinit var container: Container
    lateinit var parentView : ViewGroup
    lateinit var view: View

    abstract fun getRootLayoutId(): Int

    protected fun getRootView(): View {
        if (this::view.isInitialized) {
            return view
        }
        view = LayoutInflater.from(container.rootView.context).inflate(getRootLayoutId(), parentView, false)
        return view
    }

    open fun canHandlerMessage(): List<String> {
        return emptyList<String>()
    }

    fun dispatchMessage(message: String, content: Any? = null) {
        Log.d("Disgod", "dispatchMessage: $message")
        container.dispatchMessage(message, content)
    }

    /**
     * returns true or false, interrupt or not message translation
     */
    open fun onReceiverMessage(message: String, content: Any?) : Boolean {
        return false
    }

    /**
     * whether or not lazy init until received message
     */
    fun lazyInit() : Boolean {
        return false
    }

    fun setup(container: Container, parentView: ViewGroup) {
        if (this::container.isInitialized) {
            return
        }

        this.container = container
        this.parentView = parentView

        addRootViewToParent()

        onSetup()
    }

    private fun addRootViewToParent() {
        if (getAddIndex() != -1) {
            parentView.addView(getRootView(), getAddIndex())
        } else {
            parentView.addView(getRootView())
        }
    }

    fun destroy() {
        onDestroy()
    }

    open fun getAddIndex() : Int{
        return -1
    }

    abstract fun onSetup()

    abstract fun onDestroy()

}