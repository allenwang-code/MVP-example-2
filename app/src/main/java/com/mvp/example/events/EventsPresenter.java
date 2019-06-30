package com.mvp.example.events;

import com.mvp.example.base.BasePresenter;
import com.mvp.example.data.DataManager;
import com.mvp.example.data.remote.APIError;
import com.mvp.example.data.remote.RemoteCallback;
import com.mvp.example.events.model.EventsPage;
import com.mvp.example.events.view.EventsView;

import javax.inject.Inject;



class EventsPresenter extends BasePresenter<EventsView> {

    private DataManager dataManager;

    @Inject
    public EventsPresenter(DataManager dataManager) {
        super();
        this.dataManager = dataManager;
    }

    public void getEvents(String apiToken, String page, String searchSortType) {
        view.showProgressView();
        dataManager.getEventsList(apiToken, page, searchSortType, new RemoteCallback<EventsPage>() {
            @Override
            public void success(EventsPage response) {
                view.hideProgressView();
                view.showEventsListView();
                view.updateEventsList(response);
            }

            @Override
            public void failure(APIError error) {
                view.hideProgressView();
                view.showErrorView();
            }
        });
    }

}
