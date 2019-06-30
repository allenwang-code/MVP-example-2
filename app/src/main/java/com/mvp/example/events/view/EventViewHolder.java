package com.mvp.example.events.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mvp.example.R;

import butterknife.BindView;
import butterknife.ButterKnife;



public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.txt_event_name) TextView eventName;
    @BindView(R.id.txt_event_date) TextView eventDate;
    @BindView(R.id.img_event) ImageView eventImage;
    private EventClickListener clickListener;

    public EventViewHolder(View itemView, EventClickListener clickListener) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(clickListener != null) {
            clickListener.onEventClick(getAdapterPosition());
        }
    }
}
