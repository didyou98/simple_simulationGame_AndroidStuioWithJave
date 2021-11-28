package com.example.finalproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;


public class test extends Activity {
    Button btnLookMirror, btnTopCloset, btnDownCloset, btnBackHallway;
    Button btnPrev, btnNext;
    View dialogLookMirror, dialogTopCloset, dialogDownCloset;

    ViewFlipper viewFlipper01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        btnBackHallway = (Button) findViewById(R.id.btnBackHallway);
        btnLookMirror = (Button) findViewById(R.id.btnLookMirror);
        btnTopCloset = (Button) findViewById(R.id.btnTopCloset);
        btnDownCloset = (Button) findViewById(R.id.btnDownCloset);
        // 돌아가기
        btnBackHallway.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLookMirror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogLookMirror = (View) View.inflate(test.this, R.layout.dlg_bathroom_lookmirror, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(test.this);
                dlg.setTitle("거울 보기");
                dlg.setView(dialogLookMirror);
                btnPrev = (Button) dialogLookMirror.findViewById(R.id.btnPrev);
                btnNext = (Button) dialogLookMirror.findViewById(R.id.btnNext);
                viewFlipper01 = (ViewFlipper) dialogLookMirror.findViewById(R.id.viewFlipper01);
                btnPrev.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewFlipper01.showPrevious();
                    }
                });
                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        viewFlipper01.showNext();
                    }
                });
                dlg.setPositiveButton("그만보기", null);
                dlg.show();

            }
        });
        btnTopCloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogTopCloset = (View) View.inflate(test.this, R.layout.bathtopcloset, null);
                AlertDialog.Builder dlg1 = new AlertDialog.Builder(test.this);
                dlg1.setTitle("서랍장");
                dlg1.setView(dialogTopCloset);
                dlg1.setPositiveButton("닫기", null);
                dlg1.show();
            }
        });

        btnDownCloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogDownCloset = (View) View.inflate(test.this, R.layout.bathdowncloset, null);
                AlertDialog.Builder dlg2 = new AlertDialog.Builder(test.this);
                dlg2.setTitle("서랍장");
                dlg2.setView(dialogDownCloset);
                dlg2.setPositiveButton("닫기", null);
                dlg2.show();
            }
        });
    }
}
