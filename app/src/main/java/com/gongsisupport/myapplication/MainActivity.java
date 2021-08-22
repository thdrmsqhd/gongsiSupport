package com.gongsisupport.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.gongsisupport.myapplication.dao.Post;
import com.gongsisupport.myapplication.dao.TestDAO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 특정 버튼을 누를때 db에 접속하게 되고 결과 값을 받아올텐데
        // 어느 부분 부터 어느부분까지만 onCreate함수에 담아놓을 수 있을지 생각해본다 (리팩토링)

        // url에 따라 요청을 만드는 과정
        // 기본 url을 생성한다.
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://10.0.2.2:8080/mockTest/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
        // 기본 url으로 생성된 객체
        MockServiceWithRetrofit2 mockServiceWithRetrofit2 = retrofit.create(MockServiceWithRetrofit2.class);
        // url에 따라 요청을 만드는 과정 - 끝

        // 요청별로 call을 만든다 call 은 상황에 따라 다르다?
        Call<TestDAO> call = mockServiceWithRetrofit2.getOneMockTest();



        // 만들어진 요청을 수행하는 과정
        call.enqueue(new Callback<TestDAO>() {
            @Override
            public void onResponse(Call<TestDAO> call, Response<TestDAO> response) {
                TestDAO dao = response.body();


                //서버상에 return 이 void이기 때문에 현재 에러가 발생한다
                System.out.println(dao.toString());
            }

            @Override
            public void onFailure(Call<TestDAO> call, Throwable t) {
                System.out.println("실패");
            }
        });
        // 만들어진 요청을 수행하는 과정

    }
}