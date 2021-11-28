package com.example.finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    View dialogView;
    Button btnGoHome;
    RelativeLayout baseLayout;

    EditText doorPassword;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.btnNum0, R.id.btnNum1, R.id.btnNum2, R.id.btnNum3, R.id.btnNum4,
            R.id.btnNum5, R.id.btnNum6, R.id.btnNum7, R.id.btnNum8, R.id.btnNum9};
    String inputPassword, password;
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 도어락 열기
        password = "0123";
        btnGoHome = (Button) findViewById(R.id.btnGoHome);
        baseLayout = (RelativeLayout) findViewById(R.id.baseLayout);
        btnGoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogView = (View) View.inflate(MainActivity.this, R.layout.dlg_doorlock, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setView(dialogView);

                doorPassword = (EditText) dialogView.findViewById(R.id.doorPassword);
                for (i = 0; i < numBtnIDs.length; i++) {
                    numButtons[i] = (Button) dialogView.findViewById(numBtnIDs[i]);
                }
                for(i = 0; i < numBtnIDs.length; i++) {
                    final int index;
                    index = i;
                    numButtons[index].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (doorPassword.isFocused() == true) {
                                inputPassword = doorPassword.getText().toString() + numButtons[index].getText().toString();
                                doorPassword.setText(inputPassword);
                            } else {
                                Toast.makeText(getApplicationContext(), "에디트텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (doorPassword.getText().toString().equals(password)) {
                            Toast.makeText(getApplicationContext(), "문이 열렸습니다.",Toast.LENGTH_SHORT).show();
                            Intent goHome = new Intent(getApplicationContext(), entrance.class);
                            startActivity(goHome);
                            finish();

                        } else {
                            Toast.makeText(getApplicationContext(), "비밀번호가 틀렸습니다." ,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소", null);
                dlg.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater1 = getMenuInflater();
        mInflater1.inflate(R.menu.menu_optionmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.btnBgColorOriginal:
                baseLayout.setBackgroundColor(Color.BLACK);
                return true;
            case R.id.btnBgColorRed:
                baseLayout.setBackgroundColor(Color.RED);
                return true;
            case R.id.btnBgColorBlue:
                baseLayout.setBackgroundColor(Color.BLUE);
                return true;
            case R.id.btnBtnRotate0:
                btnGoHome.setRotation(0);
                return true;
            case R.id.btnBtnRotate45:
                btnGoHome.setRotation(45);
                return true;
        }

        return false;
    }
}