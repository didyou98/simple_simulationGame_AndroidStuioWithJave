package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class playingComputer extends Activity {
    Button btnCalc, btnBackMyRoom, btnOpenBrowser, btnGoDial, btnGoGoogleMap, btnGoSMS, btnGoPhoto, btnGoMemo;
    CheckBox chkComputerOn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_myroom_playingcomputer);

        btnCalc = (Button) findViewById(R.id.btnCalc);
        btnBackMyRoom = (Button) findViewById(R.id.btnBackMyRoom);
        btnOpenBrowser = (Button) findViewById(R.id.btnOpenBrowser);
        btnGoDial = (Button) findViewById(R.id.btnGoDial);
        btnGoGoogleMap = (Button) findViewById(R.id.btnGoGoogleMap);
        btnGoSMS = (Button) findViewById(R.id.btnGoSMS);
        btnGoPhoto = (Button) findViewById(R.id.btnGoPhoto);
        btnGoMemo = (Button) findViewById(R.id.btnGoMemo);

        chkComputerOn = (CheckBox) findViewById(R.id.chkComputerOn);

        chkComputerOn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chkComputerOn.isChecked()) {
                    btnCalc.setVisibility(View.VISIBLE);
                    btnOpenBrowser.setVisibility(View.VISIBLE);
                    btnGoDial.setVisibility(View.VISIBLE);
                    btnGoGoogleMap.setVisibility(View.VISIBLE);
                    btnGoSMS.setVisibility(View.VISIBLE);
                    btnGoPhoto.setVisibility(View.VISIBLE);
                    btnGoMemo.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "전원이 켜졌습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    btnCalc.setVisibility(View.INVISIBLE);
                    btnOpenBrowser.setVisibility(View.INVISIBLE);
                    btnGoDial.setVisibility(View.INVISIBLE);
                    btnGoGoogleMap.setVisibility(View.INVISIBLE);
                    btnGoSMS.setVisibility(View.INVISIBLE);
                    btnGoPhoto.setVisibility(View.INVISIBLE);
                    btnGoMemo.setVisibility(View.INVISIBLE);
                    Toast.makeText(getApplicationContext(), "전원이 꺼졌습니다.", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Calc1 = new Intent(getApplicationContext(), calc1.class);
                startActivity(Calc1);
            }
        });

        btnBackMyRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnOpenBrowser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent openBrowser = new Intent(getApplicationContext(), openBrowser.class);
                startActivity(openBrowser);
            }
        });

        btnGoDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("tel:01012345678");
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(intent);
            }
        });

        btnGoGoogleMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("https://maps.google.com/maps?q=" + 37.559133 + "," + 126.927824);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnGoSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.putExtra("sms_body", "반가워요");
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-3456-7890")));
                startActivity(intent);
            }
        });

        btnGoPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        btnGoMemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goMemo = new Intent(getApplicationContext(), memo.class);
                startActivity(goMemo);
            }
        });
    }
}
