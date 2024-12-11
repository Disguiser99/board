package com.disguiser.board

import android.view.ViewGroup

abstract class GroupBoard : Board() {

    var boards: MutableList<Board> = mutableListOf<Board>()

    override fun onSetup() {
        boards.forEach { board ->
            board.setup(container, getRootView() as ViewGroup)
        }
    }

    override fun onDestroy() {
        boards.forEach { board ->
            board.destroy()
        }
    }

}