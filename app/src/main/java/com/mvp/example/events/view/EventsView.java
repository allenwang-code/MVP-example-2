package com.mvp.example.events.view;

import com.mvp.example.events.model.EventsPage;



public interface EventsView {

    void showProgressView();
    void hideProgressView();
    void showEventsListView();
    void updateEventsList(EventsPage eventsPage);
    void showErrorView();

}
