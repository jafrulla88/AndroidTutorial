package com.example.androidtutorial;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPICall {
    @GET("/products/1")
        // on below line specifying the method name which we have to call.
    Call<ResponseObject> getData();

}
