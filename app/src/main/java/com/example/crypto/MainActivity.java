package com.example.crypto;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crypto.Adapter.AdapterClass;
import com.example.crypto.Apis.ApiClient;
import com.example.crypto.Apis.ApiServices;
import com.example.crypto.Apis.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    AdapterClass adapter;
    private List<Result> cryptoList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView =  findViewById(R.id.recyclerview_main);
        cryptoList = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new AdapterClass(getApplicationContext(),cryptoList);
        recyclerView.setAdapter(adapter);

        ApiServices apiService = ApiClient.getClient().create(ApiServices.class);
        Call<List<Result>> call = apiService.getlist();

        call.enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Call<List<Result>> call, Response<List<Result>> response) {
                cryptoList = response.body();
                Log.d("TAG","Response = "+cryptoList);
               adapter.setCryptolist(cryptoList);
            }

            @Override
            public void onFailure(Call<List<Result>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });



    }



}

