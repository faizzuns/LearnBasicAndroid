package com.user.profileapplication.news;

public class RetrofitService {
    public static NewsService sendRequest() {
        return RetrofitClientUtils.client().create(NewsService.class);
    }
}
