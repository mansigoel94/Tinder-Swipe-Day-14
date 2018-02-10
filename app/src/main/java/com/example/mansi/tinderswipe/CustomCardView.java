package com.example.mansi.tinderswipe;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;

/**
 * Created by Mansi on 10-02-2018.
 */

public class CustomCardView extends CardView {

    public CustomCardView(Context context) {
        super(context);
    }

    public CustomCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (isPressed()) {
            this.setCardBackgroundColor(getContext().getResources().getColor(R.color.colorPrimary));
        } else {
            this.setCardBackgroundColor(getContext().getResources().getColor(R.color.colorAccent));
        }
    }
}