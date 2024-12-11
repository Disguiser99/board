package com.disguiser.board

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.disguiser.board.template.PartyContainer

class PartyActivity: FragmentActivity() {

    private var partyContainer: PartyContainer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        partyContainer = PartyContainer(findViewById(R.id.root)).apply {
            attach()
        }
    }


    override fun onDestroy() {
        partyContainer?.destroy()
        super.onDestroy()
    }
}