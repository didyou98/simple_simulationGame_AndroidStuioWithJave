package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class hallway extends Activity {
    Button btnViewImg, btnGoEntrance, btnGoBathRoom, btnGoRoom, btnGoLivingRoom, btnGoTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_hallway);
        btnViewImg = (Button) findViewById(R.id.btnViewImg);
        btnGoEntrance = (Button) findViewById(R.id.btnGoEntrance);
        btnGoLivingRoom = (Button) findViewById(R.id.btnGoLivingRoom);
        btnGoRoom = (Button) findViewById(R.id.btnGoRoom);
        btnGoTest = (Button) findViewById(R.id.btnGoTest);

        btnGoTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTest = new Intent(getApplicationContext(), test.class);
                startActivity(goTest);
            }
        });
        //그림보기
        btnViewImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewPicture = new Intent(getApplicationContext(), viewPicture.class);
                startActivity(viewPicture);
            }
        });
        //현관가기
        btnGoEntrance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 내 방가기
        btnGoRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMyRoom = new Intent(getApplicationContext(), myroom.class);
                startActivity(goMyRoom);
            }
        });

        // 거실가기
        btnGoLivingRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLivingRoom = new Intent(getApplicationContext(), livingroom.class);
                startActivity(goLivingRoom);
            }
        });
    }
}
