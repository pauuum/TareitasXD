package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.tareitasxd.Modelo.AdapterTarea;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button btnAddTarea;
    ListView listU;
    /*ArrayAdapter adapter;
    AdapterTarea adapterTarea;*/
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddTarea = findViewById(R.id.btnAddTarea);
        listU = findViewById(R.id.listU);
        spinner = findViewById(R.id.sp_Categoria);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categoria, R.layout.item_selecciodado);
        adapter.setDropDownViewResource(R.layout.item_dropdown);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, act_prueba.class);
                startActivity(i);

            }
        });


        /*listU.setAdapter(adapterTarea);*/



    }//Fin del OnCreate()

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}