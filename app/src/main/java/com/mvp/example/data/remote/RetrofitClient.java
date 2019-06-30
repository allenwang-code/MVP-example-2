package com.mvp.example.data.remote;

import com.mvp.example.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String EVENTS_BASE_URL = "https://www.eventbriteapi.com/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofit(){

        if(retrofit == null) {

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            if(BuildConfig.DEBUG) {
                HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                httpClient.addInterceptor(interceptor);
            }

            retrofit = new Retrofit.Builder()
                    .baseUrl(EVENTS_BASE_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }

        return retrofit;
    }

}
