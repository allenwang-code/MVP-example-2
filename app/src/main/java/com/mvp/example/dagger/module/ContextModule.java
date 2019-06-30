package com.mvp.example.dagger.module;

import android.content.Context;

import com.mvp.example.dagger.ApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    @Provides
    @ApplicationScope
    Context provideContext() {
        return context;
    }

}
