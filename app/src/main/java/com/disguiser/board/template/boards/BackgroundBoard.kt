package com.disguiser.board.template.boards

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import com.disguiser.board.Board
import com.disguiser.board.R
import com.disguiser.board.template.PartyContainer

class BackgroundBoard: Board() {
    override fun getRootLayoutId(): Int {
        return R.layout.board_background
    }

    override fun canHandlerMessage(): List<String> {
        return mutableListOf(
            PartyContainer.MSG_CHANGE_BACKGROUND
        )
    }

    override fun onReceiverMessage(message: String, content: Any?): Boolean {
        Log.d("Disgod", "onReceiverMessage msg ${message}")
        when (message) {
            PartyContainer.MSG_CHANGE_BACKGROUND -> {
                getRootView().background = ColorDrawable(Color.WHITE)
                return true
            }
        }
        return super.onReceiverMessage(message, content)
    }

    override fun onSetup() {

    }

    override fun onDestroy() {

    }
}