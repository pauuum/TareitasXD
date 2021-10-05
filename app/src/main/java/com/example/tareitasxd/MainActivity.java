package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.tareitasxd.Modelo.AdapterTarea;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAddTarea;
    ListView listU;
    AdapterTarea adapterTarea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTarea = findViewById(R.id.btnAddTarea);
        listU = findViewById(R.id.listU);

        btnAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, act_prueba.class);
                startActivity(i);
            }
        });

        /*list = getIntent().getParcelableArrayListExtra( "miLista");

        adapterTarea = new AdapterTarea(getApplicationContext(), list);
        listU.setAdapter(adapterTarea);*/

    }
}