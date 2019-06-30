package com.mvp.example.dagger.module;

import android.content.Context;

import com.mvp.example.dagger.ApplicationScope;
import com.mvp.example.data.DataManager;
import com.mvp.example.events.service.EventBriteService;
import com.mvp.example.events.view.EventsRecyclerviewAdapter;

import javax.inject.Inject;

import dagger.Module;
import dagger.Provides;


@Module
public class EventsModule {

    @ApplicationScope
    @Provides
    @Inject
    DataManager providesDataManager() {
        return new DataManager(providesEventBriteService());
    }

    @ApplicationScope
    @Provides
    @Inject
    EventBriteService providesEventBriteService() {
        return EventBriteService.Creator.getEventBriteService();
    }

    @ApplicationScope
    @Provides
    @Inject
    EventsRecyclerviewAdapter providesEventsRecyclerviewAdapter(Context context) {
        return new EventsRecyclerviewAdapter(context);
    }
}
