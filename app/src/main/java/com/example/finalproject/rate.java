package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.annotation.Nullable;

public class rate extends Activity {
    Button btnGoBack;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate);
        Intent intent = getIntent();
        int voteResult = intent.getIntExtra("VoteCount", 0);
        RatingBar rbar = (RatingBar) findViewById(R.id.ratingBar);
        rbar.setRating(voteResult);
        btnGoBack = (Button) findViewById(R.id.btnGoBack);
        btnGoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
