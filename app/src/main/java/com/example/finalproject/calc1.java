package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class calc1 extends Activity {
    Button btnGoBackRoom, btnGoCalc;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlg_myroom_calc);

        btnGoBackRoom = (Button) findViewById(R.id.btnGoBackRoom);
        btnGoCalc = (Button) findViewById(R.id.btnGoCalc);

        btnGoBackRoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnGoCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                RadioGroup rdoGroup1 = (RadioGroup) findViewById(R.id.rdoGroup2);
                // 아이디도 전달해야함!
                int rdoId = rdoGroup1.getCheckedRadioButtonId();
                Intent intent = new Intent(getApplicationContext(), calc2.class);
                intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                // String.valueOf()
                intent.putExtra("rdoGroup1", Integer.parseInt(String.valueOf(rdoId)));
                startActivityForResult(intent, 0);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            int result = data.getIntExtra("result", 0);
            Toast.makeText(getApplicationContext(), "결과 : " + result, Toast.LENGTH_SHORT).show();
        }
    }
}
