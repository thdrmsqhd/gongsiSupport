package com.gongsisupport.myapplication;

import com.gongsisupport.myapplication.dao.Post;
import com.gongsisupport.myapplication.dao.TestDAO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MockServiceWithRetrofit2 {

    @POST("getOneMockTest")
    Call<TestDAO> getOneMockTest();

    @GET("posts")
    Call<List<Post>> getPosts();

}
