package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static SQLiteDatabase db; //Se define la base de datos.
    private static final String NOMBRE_BD = "MultiSQLite"; //Se define el nombre de la bd.
    private final String TABLA_TAREA = "tarea"; //Se define el nombre de la tabla.
    
    Button btnAddTarea;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, act_prueba.class);
                startActivity(i);
            }
        });
    }
}