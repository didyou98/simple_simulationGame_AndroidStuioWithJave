package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class livingroom extends Activity {
    Button btnWatchingTV, btnWatchingClock, btnWatchingAlbum, btnGoBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.livingroom);
        btnWatchingTV = (Button) findViewById(R.id.btnWatchingTV);
        btnWatchingClock = (Button) findViewById(R.id.btnWatchingClock);
        btnWatchingAlbum = (Button) findViewById(R.id.btnWatchingAlbum);
        btnGoBack = (Button) findViewById(R.id.btnGoBack);

        // 복도로 가기
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnWatchingClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent watchingClock = new Intent(getApplicationContext(), watchingClock.class);
                startActivity(watchingClock);
            }
        });

        btnWatchingTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent watchingTv = new Intent(getApplicationContext(), watchingTv.class);
                startActivity(watchingTv);
            }
        });

        btnWatchingAlbum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent watchingMovieAlbum = new Intent(getApplicationContext(), movieAlbum.class);
                startActivity(watchingMovieAlbum);
            }
        });
    }
}
