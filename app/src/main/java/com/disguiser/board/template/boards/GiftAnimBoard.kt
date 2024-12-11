package com.disguiser.board.template.boards

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import com.disguiser.board.Board
import com.disguiser.board.R
import com.disguiser.board.template.PartyContainer

class GiftAnimBoard: Board() {

    private val mHandler = Handler(Looper.myLooper()!!)

    override fun getRootLayoutId(): Int {
        return R.layout.board_gift_anim
    }

    override fun canHandlerMessage(): List<String> {
        return mutableListOf(
            PartyContainer.MSG_SEND_GIFT
        )
    }

    override fun onReceiverMessage(message: String, content: Any?): Boolean {
        when (message) {
            PartyContainer.MSG_SEND_GIFT -> {
                getRootView().visibility = View.VISIBLE
                mHandler.postDelayed({
                    getRootView().visibility = View.GONE
                }, 3000)
            }
        }
        return super.onReceiverMessage(message, content)
    }

    override fun onSetup() {

    }

    override fun onDestroy() {
        mHandler.removeCallbacksAndMessages(null)
    }
}