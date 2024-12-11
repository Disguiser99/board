package com.disguiser.board.template.boards

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.disguiser.board.Board
import com.disguiser.board.R
import com.disguiser.board.template.PartyContainer

class HeaderBoard: Board() {
    override fun getRootLayoutId(): Int {
        return R.layout.board_header
    }

    override fun onSetup() {
        getRootView().setOnClickListener {
            Log.d("Disgod", "onClick")
            dispatchMessage(PartyContainer.MSG_CHANGE_BACKGROUND)
        }
    }

    override fun onDestroy() {

    }
}