package com.user.profileapplication.news;

import com.user.profileapplication.news.response.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsService {

    String apiKey = "825d062f21d24ee493efba6c246822e0";

    @GET("everything")
    Call<NewsResponse> callNews(@Query("q") String keyword, @Query("apiKey") String apiKey);
}
