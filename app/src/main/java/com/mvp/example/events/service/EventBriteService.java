package com.mvp.example.events.service;

import com.mvp.example.data.remote.RetrofitClient;
import com.mvp.example.events.model.EventsPage;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EventBriteService {

    @GET("/v3/events/search/")
    Call<EventsPage> getEventsList(@Query("token") String token, @Query("page") String page, @Query("sort_by") String sortBy);

    class Creator {
        public static EventBriteService getEventBriteService() {
            return RetrofitClient.getRetrofit().create(EventBriteService.class);
        }
    }

}
