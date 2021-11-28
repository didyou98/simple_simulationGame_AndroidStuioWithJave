package com.example.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


public class entrance extends Activity {
    View openClosetView, toastView;
    ImageView showShoe;
    RadioGroup rdoGroup1;
    RadioButton showFshoe, showSshoe, showTshoe;
    Button btnshowShoe;
    Boolean isWearShoe;
    Button btnShoeOff, btnShoeOn, btnGoHallWay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.na_entrance);

        isWearShoe = true;
        // 밖으로 나가기
        Button btnBack = (Button) findViewById(R.id.btnGoFirstArea);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isWearShoe == true) {
                    Intent goFirstArea = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(goFirstArea);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "신발을 신자", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 신발장 열기
        Button btnOpenShoeCloset = (Button) findViewById(R.id.openShoeCloset);
        btnOpenShoeCloset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openClosetView = (View) View.inflate(entrance.this, R.layout.shoecloset, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(entrance.this);
                dlg.setTitle("신발장");
                dlg.setView(openClosetView);
                rdoGroup1 = (RadioGroup) openClosetView.findViewById(R.id.rdoGroup);
                showFshoe = (RadioButton) openClosetView.findViewById(R.id.rdoFshoe);
                showSshoe = (RadioButton) openClosetView.findViewById(R.id.rdoSshoe);
                showTshoe = (RadioButton) openClosetView.findViewById(R.id.rdoTshoe);
                showShoe = (ImageView) openClosetView.findViewById(R.id.showShoe);
                btnshowShoe = (Button) openClosetView.findViewById(R.id.btnShowShoe);
                btnshowShoe.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        switch (rdoGroup1.getCheckedRadioButtonId()) {
                            case R.id.rdoFshoe:
                                showShoe.setImageResource(R.drawable.shoe1);
                                break;
                            case R.id.rdoSshoe:
                                showShoe.setImageResource(R.drawable.shoe2);
                                break;
                            case R.id.rdoTshoe:
                                showShoe.setImageResource(R.drawable.shoe3);
                                break;
                            default:
                                Toast.makeText(getApplicationContext(), "버튼을 선택하세요", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                dlg.setPositiveButton("닫기", null);
                dlg.show();
            }
        });
        btnShoeOff = (Button) findViewById(R.id.btnShoeOff);
        btnShoeOn = (Button) findViewById(R.id.btnShoeOn);

        btnShoeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isWearShoe == true) {
                    isWearShoe = false;
                    Toast.makeText(getApplicationContext(), "신발을 벗었다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "신발을 이미 벗었다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnShoeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isWearShoe == false) {
                    isWearShoe = true;
                    Toast.makeText(getApplicationContext(), "신발을 신었다.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "신발을 이미 신었다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
        // 복도로 들어가기
        btnGoHallWay = (Button) findViewById(R.id.btnGoHallWay);
        btnGoHallWay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isWearShoe == true) {
                    Toast toast = new Toast(entrance.this);
                    toastView = (View) View.inflate(entrance.this, R.layout.toast1, null);
                    toast.setView(toastView);
                    toast.show();
                } else {
                    Intent goHallWay = new Intent(getApplicationContext(), hallway.class);
                    startActivity(goHallWay);
                }
            }
        });
    }
}
