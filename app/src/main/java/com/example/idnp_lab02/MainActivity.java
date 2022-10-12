package com.example.idnp_lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private static String TAG = "MainActivity";
    private EditText edtNombres;
    private EditText edtApPaterno;
    private EditText edtApMaterno;
    private EditText edtFecha;
    private EditText edtColegio;
    private EditText edtCarrera;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtNombres = findViewById(R.id.edtNombres);
        edtApPaterno = findViewById(R.id.edtApPaterno);
        edtApMaterno = findViewById(R.id.edtApMaterno);
        edtFecha = findViewById(R.id.edtFecha);
        edtColegio = findViewById(R.id.edtColegio);
        edtCarrera = findViewById(R.id.edtCarrera);
        btnEnviar = findViewById(R.id.btnEnviar);

        final Calendar calendario = Calendar.getInstance();
        final int aaaa = calendario.get(Calendar.YEAR);
        final int mm = calendario.get(Calendar.MONTH);
        final int dd = calendario.get(Calendar.DAY_OF_MONTH);

        edtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String date = dd + "/" + month + "/" + year;
                        edtFecha.setText(date);
                    }
                }, aaaa, mm, dd);
                dialog.show();
            }
        });

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombres = edtNombres.getText().toString();
                String apellidoPat = edtApPaterno.getText().toString();
                String apellidoMat = edtApMaterno.getText().toString();
                String fecha = edtFecha.getText().toString();
                String colegio = edtColegio.getText().toString();
                String carrera = edtCarrera.getText().toString();

                Log.d(TAG, "Nombres:" + nombres + ", Apellido Paterno:" + apellidoPat + ", Apellido Materno:" + apellidoMat + ", Fecha de Nacimiento:" + fecha + ", Colegio:" + colegio + ", Carrera:" + carrera );
            }
        });

    }
}
