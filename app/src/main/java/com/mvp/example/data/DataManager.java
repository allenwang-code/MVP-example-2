package com.mvp.example.data;

import com.mvp.example.data.remote.RemoteCallback;
import com.mvp.example.events.service.EventBriteService;
import com.mvp.example.events.model.EventsPage;

import javax.inject.Inject;

public class DataManager {

    private EventBriteService eventBriteService;

    @Inject
    public DataManager(EventBriteService eventBriteService) {
        this.eventBriteService = eventBriteService;
    }

    public void getEventsList(String token, String page, String sortBy, RemoteCallback<EventsPage> remoteCallback) {
        eventBriteService.getEventsList(token, page, sortBy).enqueue(remoteCallback);
    }

}
