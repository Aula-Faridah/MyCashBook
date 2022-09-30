package org.aplas.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class PengeluaranActivity extends AppCompatActivity {

    EditText editdate, editnom, editket;
    Button save, back;
    SqliteHelper DB;
    DatePickerDialog datePickerDialog;
    SimpleDateFormat dateFormatter;

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                editdate.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengeluaran);

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        editdate = findViewById(R.id.editTanggal);
        editnom = findViewById(R.id.editNominalPengeluaran);
        editket = findViewById(R.id.editKeteranganPengeluaran);
        save = findViewById(R.id.btnSave);
        back = findViewById(R.id.btnKembali);
        DB = new SqliteHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float nom = Float.parseFloat(editnom.getText().toString());
                String ket = editket.getText().toString();
                String date = String.valueOf(editdate.getText().toString());

            }
        });

        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent intent = new Intent(PengeluaranActivity.this, BerandaActivity.class);
                startActivity(intent);
                finish();
            }
        });

        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        editdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

    }

}
