package org.aplas.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingActivity extends AppCompatActivity {
    Button btnsimpan,btnkembali;
    EditText pass, newpass;
    protected Cursor cursor;
    SqliteHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        pass = findViewById(R.id.edittextPassword);
        newpass  = findViewById(R.id.edittextPassword2);
        btnsimpan = findViewById(R.id.btnSave);
        btnkembali = findViewById(R.id.btnKembali);
        DB = new SqliteHelper(this);

        SQLiteDatabase db = DB.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM user WHERE username = '" +
                getIntent().getStringExtra("username") + "'",null);
        cursor.moveToFirst();

        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            newpass.setText(cursor.getString(0).toString());
        }

        btnsimpan.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                SQLiteDatabase db = DB.getWritableDatabase();
                db.execSQL("update user set password='"+
                        newpass.getText().toString() +"' where id='");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(SettingActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btnkembali.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SettingActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

}
