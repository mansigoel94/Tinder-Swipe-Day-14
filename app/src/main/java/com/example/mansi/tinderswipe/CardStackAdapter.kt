package com.example.mansi.tinderswipe

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import java.security.AccessController.getContext
import java.util.ArrayList

class CardStackAdapter(val context1: Context,
                       val cardStackArrayList: ArrayList<CardStack>)
    : ArrayAdapter<CardStack>(context1, 0, cardStackArrayList) {

    override fun getView(position: Int, contentView: View?, parent: ViewGroup): View {
        var contentView = contentView
        val holder: ViewHolder
        if (contentView == null) {
            val inflater = LayoutInflater.from(context)
            contentView = inflater.inflate(R.layout.item_cardstack, parent, false)
            holder = ViewHolder(contentView)
            contentView!!.tag = holder
        } else {
            holder = contentView.tag as ViewHolder
        }

        val (imageView, text) = cardStackArrayList[position]

/*        holder.cardView.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
                holder.cardView.setBackgroundColor(Color.TRANSPARENT)
                return true
            }
        })*/

        holder.image.setImageDrawable(context1.resources.getDrawable(imageView))
        holder.text.text = text
        return contentView
    }

    private class ViewHolder(view: View) {
        var text: TextView
        var image: ImageView
        var cardView: CardView

        init {
            this.text = view.findViewById<View>(R.id.checkedTextView) as TextView
            this.image = view.findViewById<View>(R.id.image) as ImageView
            this.cardView = view.findViewById<View>(R.id.cardView) as CardView
        }
    }
}
