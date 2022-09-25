package com.example.osos_assignment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiCall {

    //https://run.mocky.io/v3/a3f75434-1266-4ddc-a85e-ca45d2131bf9
    @GET("a3f75434-1266-4ddc-a85e-ca45d2131bf9")
    Call<List<ArrayMultipleObjectModel>> getData();

}
