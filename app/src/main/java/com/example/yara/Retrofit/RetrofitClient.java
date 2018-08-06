package com.example.yara.Retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}

interface GetDataService {
    @GET("/users")
    Call<List<RetrofitUser>> getAllUsers();

    @GET("/posts" )
    Call<List<Post>> getPosts(@Query("userId") int userId);
}


