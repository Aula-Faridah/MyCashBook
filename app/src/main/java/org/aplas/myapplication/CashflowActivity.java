package org.aplas.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CashflowActivity extends AppCompatActivity {
    Button back;
    RecyclerView rv;
    DetailAdapter detailAdapter;
    List<DetailModel> keuanganList = new ArrayList<>();
    SqliteHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_cashflow);

        back = findViewById(R.id.btnKembali);
        rv = findViewById(R.id.rv_cashflow);
        rv.setLayoutManager(new LinearLayoutManager(CashflowActivity.this));
        DB = new SqliteHelper(this);

        getDataTrans();

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(CashflowActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    void getDataTrans(){

        keuanganList.clear();
        keuanganList = DB.getDataTrans();
        detailAdapter = new DetailAdapter(keuanganList);

        if (detailAdapter.getItemCount()==0) {
            Toast.makeText(CashflowActivity.this, "Empty", Toast.LENGTH_SHORT).show();
        } else {
            rv.setAdapter(detailAdapter);
        }
    }

}