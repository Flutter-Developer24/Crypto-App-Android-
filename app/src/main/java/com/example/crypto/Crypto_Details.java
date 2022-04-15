package com.example.crypto;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.crypto.Apis.Result;

public class Crypto_Details extends AppCompatActivity {
    TextView symbol, quoteAsset, volume, highprice, lowprice, lastprice,baseasset,openprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detials_page);
        getSupportActionBar().hide();


      findid();

        Intent intent  = getIntent();

        String data = intent.getStringExtra("crypto");
        String data1 = intent.getStringExtra("crypto1");
        String data2 = intent.getStringExtra("crypto2");
        String data3 = intent.getStringExtra("crypto3");
        String data4 = intent.getStringExtra("crypto4");
        String data5 = intent.getStringExtra("crypto5");
        String data6 = intent.getStringExtra("crypto6");
        String data7 = intent.getStringExtra("crypto7");





        symbol.setText(data);
        quoteAsset.setText(data1);
        volume.setText(data2);
        highprice.setText(data3);
        lowprice.setText(data4);
        lastprice.setText(data5);
        baseasset.setText(data6);
       openprice.setText(data7);






    }

    public void findid(){
        symbol = findViewById(R.id.view_symbol);
        quoteAsset=findViewById(R.id.view_quoteasset);
        volume = findViewById(R.id.view_volume);
        highprice=findViewById(R.id.view_highprice);
        lowprice =findViewById(R.id.view_lowprice);
        lastprice =findViewById(R.id.view_lastprice);
        baseasset =findViewById(R.id.view_baseasset);
        openprice =findViewById(R.id.view_openprice);
    }



}