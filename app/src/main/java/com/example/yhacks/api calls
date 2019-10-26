package com.example.maylisw.apipractice;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maylisw on 1/23/18.
 */

public interface UINames {
    String baseURL = "http://uinames.com/";
    @GET("api")
    Call<List<People>> getNumberOfPeople(@Query("amount") int numberOfNames, @Query("region") String region); // receives data asynchronously
}
