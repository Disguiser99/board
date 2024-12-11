package com.disguiser.board

import android.view.ViewGroup

public abstract class Container(val rootView: ViewGroup) {

    var mBoards: MutableList<Board> = mutableListOf<Board>()

    open fun attach() {
        onSetup()
    }

    private fun onSetup() {
        for (board in mBoards) {
            if (board.lazyInit().not()) {
                onSetupBoard(board)
            }
        }
    }

    private fun onSetupBoard(board: Board) {
        board.setup(this, rootView)
    }

    fun dispatchMessage(message: String, content: Any? = null) {
        onDispatchMessage(mBoards, message, content)
    }

    open fun canHandlerMessage(): List<String> {
        return mutableListOf<String>()
    }

    open fun onReceiverMessage(message: String, content: Any?) : Boolean {
        return false
    }

    private fun onDispatchMessage(boards: MutableList<Board>, message: String, content: Any? = null): Boolean {
        if (canHandlerMessage().contains(message)) {
            if (onReceiverMessage(message, content)) {
                return true
            }
        }

        for (board in boards) {
            if (board is GroupBoard) {
                if (onDispatchMessage(board.boards, message, content)) {
                    return true
                }
            } else {
                if (board.canHandlerMessage().contains(message)) {
                    if (board.inited.not()) {
                        onSetupBoard(board)
                    }
                    if (board.onReceiverMessage(message, content)) {
                        return true
                    }
                }
            }

        }
        return false
    }


    fun <T: Board> getBoard(clazz: Class<T>) : T? {
        return mBoards.find { clazz.isInstance(it) } as? T
    }

    open fun destroy() {
        mBoards.forEach { it.destroy() }
        mBoards.clear()
    }
}