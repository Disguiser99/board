package com.disguiser.board.template.boards

import android.view.LayoutInflater
import android.view.View
import com.disguiser.board.Board
import com.disguiser.board.R
import com.disguiser.board.template.PartyContainer

class BottomBoard : Board() {
    override fun getRootLayoutId(): Int {
        return R.layout.board_bottom
    }

    override fun onSetup() {
        getRootView().setOnClickListener {
            dispatchMessage(PartyContainer.MSG_SEND_GIFT)
        }
    }

    override fun onDestroy() {

    }
}