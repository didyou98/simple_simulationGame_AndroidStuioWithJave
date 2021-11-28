package com.example.finalproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;


public class viewPicture extends Activity {
    Button btnBackViewPicture, btnImgEdit;
    ImageView imgView01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpicture);
        imgView01 = (ImageView) findViewById(R.id.imgView01);
        btnImgEdit = (Button) findViewById(R.id.btnImgEdit);
        registerForContextMenu(btnImgEdit);
        btnBackViewPicture = (Button) findViewById(R.id.btnBackViewPicture);
        btnBackViewPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if(v == btnImgEdit) {
            menu.setHeaderTitle("그림변경하기");
            mInflater.inflate(R.menu.menu_viewpicture, menu);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.rotateImg:
                imgView01.setRotation(0);
                return true;
            case R.id.scaleImg:
                imgView01.setScaleX(2);
                return true;
        }

        return false;
    }
}
