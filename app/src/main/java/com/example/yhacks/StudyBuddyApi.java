package com.example.yhacks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.DELETE;
import retrofit2.http.Body;
import retrofit2.http.Query;

/**
 * Created by maylisw on 1/23/18.
 */

public interface StudyBuddyApi {
    String baseURL = "https://www.mystudybuddy.tech/api/v1/";

    @FormUrlEncoded
    @POST("users")
    Call<User> registerUser(
            @Field("email") String email,
            @Field("name") String name,
            @Field("university") String university,
            @Field("password") String password,
            @Field("password_confirmation") String passwordConfirmation
    );
    

    @FormUrlEncoded
    @POST("sessions")
    Call<User> login(
            @Field("email") String email,
            @Field("password") String password
    );

}