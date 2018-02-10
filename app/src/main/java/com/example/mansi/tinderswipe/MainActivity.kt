package com.example.mansi.tinderswipe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import com.lorentzos.flingswipe.FlingCardListener
import com.yuyakaido.android.cardstackview.CardStackView
import com.yuyakaido.android.cardstackview.SwipeDirection
import kotlinx.android.synthetic.main.activity_main.*
import android.widget.Toast
import com.lorentzos.flingswipe.SwipeFlingAdapterView
import kotlinx.android.synthetic.main.item_cardstack.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CardStackAdapter(this, generateRandomData())
        activity_main_card_stack_view.
                setAdapter(adapter)

        /*  activity_main_card_stack_view.setFlingListener(object : SwipeFlingAdapterView.onFlingListener {
            override fun onScroll(p0: Float) {
            }

            override fun removeFirstObjectInAdapter() {
                // this is the simplest way to delete an object from the Adapter (/AdapterView)
                Log.d("LIST", "removed object!")
//                al.remove(0)
//                arrayAdapter.notifyDataSetChanged()
            }

            override fun onLeftCardExit(dataObject: Any) {
                //Do something on the left!
                //You also have access to the original object.
                //If you want to use it just cast it (String) dataObject
                // Toast.makeText(this@MainActivity,"dsjfsd",Toast.LENGTH_LONG).show()
                Toast.makeText(this@MainActivity, "Left!", Toast.LENGTH_SHORT).show()
            }

            override fun onRightCardExit(dataObject: Any) {
                Toast.makeText(this@MainActivity, "Right!", Toast.LENGTH_SHORT).show()
            }

            override fun onAdapterAboutToEmpty(itemsInAdapter: Int) {
                // Ask for more data here
                *//*       al.add("XML " + String.valueOf(i))
                       arrayAdapter.notifyDataSetChanged()*//*
                Log.d("LIST", "notified")
            }
        })*/

        activity_main_card_stack_view.setCardEventListener(object : CardStackView.CardEventListener {
            override fun onCardDragging(percentX: Float, percentY: Float) {

            }

            override fun onCardSwiped(direction: SwipeDirection) {
                if (activity_main_card_stack_view.getTopIndex() == adapter.count - 1) {
                    activity_main_card_stack_view.setPaginationReserved()
                    // adapter.clear();
                    adapter.addAll(generateRandomData())
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onCardReversed() {

            }

            override fun onCardMovedToOrigin() {

            }

            override fun onCardClicked(index: Int) {

            }
        })
    }

    private fun generateRandomData(): ArrayList<CardStack> {
        val cardsStacks: ArrayList<CardStack> = ArrayList()
        cardsStacks.add(CardStack(R.drawable.minion_1, "Minion 1"))
        cardsStacks.add(CardStack(R.drawable.minion_2, "Minion 2"))
        cardsStacks.add(CardStack(R.drawable.minion_3, "Minion 3"))
        cardsStacks.add(CardStack(R.drawable.minion_4, "Minion 4"))
        cardsStacks.add(CardStack(R.drawable.minion_5, "Minion 5"))
        cardsStacks.add(CardStack(R.drawable.minion_1, "Minion 6"))
        cardsStacks.add(CardStack(R.drawable.minion_2, "Minion 7"))
        cardsStacks.add(CardStack(R.drawable.minion_3, "Minion 8"))
        cardsStacks.add(CardStack(R.drawable.minion_4, "Minion 9"))
        cardsStacks.add(CardStack(R.drawable.minion_5, "Minion 10"))
        return cardsStacks
    }
}

