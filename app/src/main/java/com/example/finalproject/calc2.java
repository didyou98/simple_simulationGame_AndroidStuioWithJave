package com.example.finalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class calc2 extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dlg_myroom_calc_2);
        final Intent inIntent = getIntent();
        final int returnAdd = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        final int returnSub = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        final int returnMul = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        final int returnDiv = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        final int rdoGroup1 = inIntent.getIntExtra("rdoGroup1", 0);
        Button btnReturn = (Button) findViewById(R.id.btnIntentBack);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rdoGroup1) {
                    case R.id.rdoCalcSum:
                        Intent outIntentAdd = new Intent(getApplicationContext(), calc2.class);
                        outIntentAdd.putExtra("result", returnAdd);
                        setResult(RESULT_OK, outIntentAdd);
                        finish();
                        break;
                    case R.id.rdoCalcSub:
                        Intent outIntentSub = new Intent(getApplicationContext(), calc2.class);
                        outIntentSub.putExtra("result", returnSub);
                        setResult(RESULT_OK, outIntentSub);
                        finish();
                        break;
                    case R.id.rdoCalcMul:
                        Intent outIntentMul = new Intent(getApplicationContext(), calc2.class);
                        outIntentMul.putExtra("result", returnMul);
                        setResult(RESULT_OK, outIntentMul);
                        finish();
                        break;
                    case R.id.rdoCalcDiv:
                        Intent outIntentDiv = new Intent(getApplicationContext(), calc2.class);
                        outIntentDiv.putExtra("result", returnDiv);
                        setResult(RESULT_OK, outIntentDiv);
                        finish();
                        break;
                }

            }
        });
    }
}
