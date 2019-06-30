package com.mvp.example.dagger.component;

import com.mvp.example.dagger.ApplicationScope;
import com.mvp.example.dagger.module.ContextModule;
import com.mvp.example.dagger.module.EventsModule;
import com.mvp.example.events.EventsListActivity;

import dagger.Component;

@Component(modules = {EventsModule.class, ContextModule.class})
@ApplicationScope
public interface AppComponent {
    void inject(EventsListActivity eventsActivity);
}
