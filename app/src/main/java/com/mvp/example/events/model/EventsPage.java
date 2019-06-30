package com.mvp.example.events.model;

import java.util.List;

public class EventsPage {

    private Pagination pagination;
    private List<Event> events;

    public Pagination getPagination() {
        return pagination;
    }

    public List<Event> getEvents() {
        return events;
    }

    public EventsPage(Pagination pagination, List<Event> events) {
        this.pagination = pagination;
        this.events = events;
    }

}
