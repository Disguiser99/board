package com.disguiser.board.template.boards

import android.view.LayoutInflater
import android.view.View
import com.disguiser.board.Board
import com.disguiser.board.R

class MessageBoard: Board() {
    override fun getRootLayoutId(): Int {
        return R.layout.board_message
    }

    override fun onSetup() {

    }

    override fun onDestroy() {

    }
}