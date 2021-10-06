package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ListView listaPrincipal;
    Button btnAddTarea;
    ArrayAdapter adapter;
    Adapter adapterItem;

    ArrayList<Task> listaC;
    ArrayList<Task> listF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spPrincipal);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnAddTarea = findViewById(R.id.btnAddTarea);
        listaPrincipal = findViewById(R.id.listaPrincipal);


        btnAddTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, act_prueba.class);
                startActivity(i);
            }
        });

        listaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapterItem = new Adapter(getApplicationContext(), registro.devolverLista());
                listaPrincipal.setAdapter(adapterItem);
            }
        });

    }

    private ArrayList<Task> filtrarLista (String categoria, ArrayList<Task> listaC){
        ArrayList<Task> listF = new ArrayList<>();
        if(categoria.equalsIgnoreCase("Todos"))
        {
            listF = listaC;
        }else{
            for (int i = 0; i < listaC.size(); i++){
                if(categoria.equalsIgnoreCase(listaC.get(i).getCategoria())){
                    listF.add(listaC.get(i));
                }
            }
        }
        return listF;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}