package com.mvp.example.events.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mvp.example.R;
import com.mvp.example.events.model.Event;
import com.mvp.example.events.model.EventsPage;
import com.mvp.example.events.model.Logo;
import com.mvp.example.util.DateTimeUtil;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EventsRecyclerviewAdapter extends RecyclerView.Adapter<EventViewHolder> {

    private Context context;
    private List<Event> events = new ArrayList<>();
    private EventClickListener eventClickListener;

    public List<Event> getEvents() {
        return events;
    }

    public EventsRecyclerviewAdapter(Context context) {
        this.context = context;
    }

    public void setEventClickListener(EventClickListener eventClickListener){
        this.eventClickListener = eventClickListener;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_item, parent, false);
        return new EventViewHolder(view, eventClickListener);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        if(holder == null) {
            return;
        }

        Event event = events.get(position);
        holder.eventName.setText(event.getName().getText());
        holder.eventDate.setText(DateTimeUtil.convertDate(event.getStart().getLocal()));
        Logo eventLogo = event.getLogo();
        if (eventLogo != null) {
            Picasso.with(context)
                    .load(eventLogo.getUrl())
                    .placeholder(R.drawable.img_placeholder)
                    .error(R.drawable.img_placeholder)
                    .into(holder.eventImage);
        }

    }

    @Override
    public int getItemViewType(int position) {
        return events.get(position) != null ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

    public void updateEventsList(EventsPage eventsPage) {
        notifyItemRangeInserted(events.size() - 1, eventsPage.getEvents().size());
        events.addAll(eventsPage.getEvents());
    }

}
