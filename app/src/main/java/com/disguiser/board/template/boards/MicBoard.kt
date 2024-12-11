package com.disguiser.board.template.boards

import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.disguiser.board.Board
import com.disguiser.board.R
import com.disguiser.board.template.PartyContainer

class MicBoard: Board() {
    override fun getRootLayoutId(): Int {
        return R.layout.board_mic
    }

    private var showNum = 0

    override fun onSetup() {
        getRootView().setOnClickListener {
            it.findViewById<TextView>(R.id.tv_num).text = (showNum++).toString()
            dispatchMessage(PartyContainer.MSG_ENTER)
        }
    }

    override fun onDestroy() {

    }
}