package com.disguiser.board.template

import android.view.ViewGroup
import com.disguiser.board.Container
import com.disguiser.board.template.boards.BackgroundBoard
import com.disguiser.board.template.boards.BottomBoard
import com.disguiser.board.template.boards.EnterAnimBoard
import com.disguiser.board.template.boards.GiftAnimBoard
import com.disguiser.board.template.boards.HeaderBoard
import com.disguiser.board.template.boards.MessageBoard
import com.disguiser.board.template.boards.MicBoard

class PartyContainer(private val root: ViewGroup): Container(root) {


    companion object {
        const val MSG_ENTER = "msg_enter"
        const val MSG_SEND_GIFT = "msg_send_gift"
        const val MSG_CHANGE_BACKGROUND = "msg_change_background"
    }

    init {
        mBoards = mutableListOf(
            BackgroundBoard(),
            HeaderBoard(),
            MicBoard(),
            MessageBoard(),
            BottomBoard(),
            GiftAnimBoard(),
            EnterAnimBoard(),
        )
    }

    override fun canHandlerMessage(): List<String> {
        return super.canHandlerMessage()
    }

    override fun onReceiverMessage(message: String, content: Any?): Boolean {
        return super.onReceiverMessage(message, content)
    }



}