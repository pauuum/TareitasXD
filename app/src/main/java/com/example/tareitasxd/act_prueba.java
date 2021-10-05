package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class act_prueba extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static SQLiteDatabase db; //Se define la base de datos.
    private static final String NOMBRE_BD = "MultiSQLite"; //Se define el nombre de la bd.
    private final String TABLA_TAREA = "tarea"; //Se define el nombre de la tabla.

    EditText txtNombre, txtDescripcionTarea, txtFecha, txtHora;
    Button btnCrearTarea;
    String categoria = "";
    String N1, D2, F3, H4;


    public static final String tbTarea = "CREATE TABLE IF NOT EXISTS tarea(id INTEGER PRIMARY KEY AUTOINCREMENT, "+"" +
            "txtNombre STRING NOT NULL," + "txtDescripcionTarea STRING NOT NULL," + "txtFecha STRING NOT NULL," + "txtHora STRING NOT NULL," + "categoria STRING NOT NULL);";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        abrirDataBase();

        setContentView(R.layout.lyt_prueba);
        txtNombre = findViewById(R.id.txtNombre);
        txtDescripcionTarea = findViewById(R.id.txtDescripcionTarea);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);
        btnCrearTarea = findViewById(R.id.btnCrearTarea);


        Spinner spinner = findViewById(R.id.spCrear);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.categorias, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        btnCrearTarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N1 = txtNombre.getText().toString();
                D2 = txtDescripcionTarea.getText().toString();
                F3 = txtFecha.getText().toString();
                H4 = txtHora.getText().toString();


                if(!TextUtils.isEmpty(N1) && !TextUtils.isEmpty(D2) && !TextUtils.isEmpty(F3) && !TextUtils.isEmpty(H4) && !TextUtils.isEmpty(categoria)){
                    /*factor1 = Float.parseFloat(f1);
                    factor2 = Float.parseFloat(f2);*/


                    if(addOperacion(N1, D2, F3, H4, categoria )){
                        Toast.makeText(getApplicationContext(), "Agregado correctamente", Toast.LENGTH_SHORT).show();
                        limpiar();
                    }else{
                        Toast.makeText(getApplicationContext(), "Error al agregar en la base de datos", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });



    }//Fin onCreate

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        categoria = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void abrirDataBase(){
        try{
            db = openOrCreateDatabase(NOMBRE_BD, MODE_PRIVATE, null);
            db.execSQL(tbTarea);
        }catch (SQLiteOutOfMemoryException e){
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Error al crear la base de datos", Toast.LENGTH_SHORT).show();
        }
    }//FIn abrirDataBase()

    private boolean addOperacion(String txtNombre, String txtDescripcionTarea, String txtFecha, String txtHora, String categoria){
        /*Es un diccionario o contenedor que almacena pares de clave - valor, los nombres
         * de las columnas y los valores a almacenar en la bd*/
        ContentValues content  = new ContentValues();
        content.put("txtNombre", txtNombre);
        content.put("txtDescripcionTarea", txtDescripcionTarea);
        content.put("txtFecha", txtFecha );
        content.put("txtHora", txtHora);
        content.put("categoria", categoria);
        return db.insert(TABLA_TAREA, null, content) > 0; /*gregar a la bd*/
    }//Fin addOperacion

    public void limpiar(){
        txtNombre.setText("");
        txtDescripcionTarea.setText("");
        txtFecha.setText("");
        txtHora.setText("");

    }// FIn LImpiar

}