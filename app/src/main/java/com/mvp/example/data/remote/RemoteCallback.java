package com.mvp.example.data.remote;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RemoteCallback<T> implements Callback<T> {

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()){
            success(response.body());
        } else {
            APIError apiError = new APIError(response.code(), response.errorBody().toString());
            failure(apiError);
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        if(t instanceof IOException) {
            failure(new APIError(0, "Timeout error"));
        } else if (t instanceof IllegalStateException) {
            failure(new APIError(0, "JSON error"));
        } else {
            failure(new APIError(0, "Unknown error"));
        }

    }

    public abstract void success(T response);

    public abstract void failure(APIError error);

}
