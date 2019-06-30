package com.mvp.example;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.mvp.example.dagger.component.AppComponent;
import com.mvp.example.dagger.component.DaggerAppComponent;
import com.mvp.example.dagger.module.ContextModule;
import com.mvp.example.dagger.module.EventsModule;

public class EventApplication extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .eventsModule(new EventsModule())
                .contextModule(new ContextModule(getApplicationContext()))
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @VisibleForTesting
    public void setAppComponent(AppComponent appComponent) {
        this.appComponent = appComponent;
    }

}
