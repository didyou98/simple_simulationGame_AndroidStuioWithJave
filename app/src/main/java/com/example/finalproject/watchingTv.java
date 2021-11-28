package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class watchingTv extends Activity {
    ImageButton imgbtn1;
    Button btnGoRate, btnBackLiving;
    int voteCount = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_livingroom_watchingtv);
        imgbtn1 = (ImageButton) findViewById(R.id.imgBtn1);
        btnGoRate = (Button) findViewById(R.id.btnGoRate);
        btnBackLiving = (Button) findViewById(R.id.btnBackLiving);


        imgbtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voteCount += 1;
                Toast.makeText(getApplicationContext(), "무한도전 시청 평가 총 : " + voteCount, Toast.LENGTH_SHORT).show();
            }
        });

        btnGoRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), rate.class);
                intent.putExtra("VoteCount", voteCount);
                startActivity(intent);
            }
        });
        btnBackLiving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
