package com.example.yhacks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by maylisw on 1/23/18.
 */

public interface StudyBuddyApi {
    String baseURL = "https://www.mystudybuddy.tech";

    @GET("api/v1/users")
    Call<User> getAllUsers();
}