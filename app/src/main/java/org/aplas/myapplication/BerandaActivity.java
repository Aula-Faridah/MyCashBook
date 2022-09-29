package org.aplas.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class BerandaActivity extends AppCompatActivity {
    ImageButton btnincome, btnexpense, btncashflow, btnsetting;
    TextView totalincome, totalexpense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);

        btnincome = findViewById(R.id.imgbtnincome);
        btnexpense = findViewById(R.id.imgbtnexpense);
        btncashflow = findViewById(R.id.imgbtncashflow);
        btnsetting = findViewById(R.id.imgbtnsetting);

        btnincome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BerandaActivity.this, PemasukanActivity.class);
                startActivity(i);
            }
        });

        btnexpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BerandaActivity.this, PengeluaranActivity.class);
                startActivity(i);
            }
        });

        btncashflow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BerandaActivity.this, CashflowActivity.class);
                startActivity(i);
            }
        });

        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(BerandaActivity.this, SettingActivity.class);
                startActivity(i);
            }
        });
    }
}
