package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class myroom extends Activity {
    Button btnGoBackHall, btnWatchingPicture, btnPlayComputer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_myroom);

        btnGoBackHall = (Button) findViewById(R.id.btnGoBackHallWay);
        btnWatchingPicture = (Button) findViewById(R.id.btnWatchingPicture);
        btnPlayComputer = (Button) findViewById(R.id.btnPlayComputer);

        btnGoBackHall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnWatchingPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent watchingPictureAlbum = new Intent(getApplicationContext(), watchingPictureAlbum.class);
                startActivity(watchingPictureAlbum);

            }
        });

        btnPlayComputer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playingComputer = new Intent(getApplicationContext(), playingComputer.class);
                startActivity(playingComputer);
            }
        });
    }
}
