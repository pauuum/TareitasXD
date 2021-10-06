package com.example.tareitasxd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOutOfMemoryException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class act_prueba extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private static SQLiteDatabase db; //Se define la base de datos.
    private static final String NOMBRE_BD = "MultiSQLite"; //Se define el nombre de la bd.
    private final String TABLA_TAREA = "tarea"; //Se define el nombre de la tabla.

    EditText txtNombre, txtDescripcionTarea, txtFecha, txtHora;
    TextView identificador;
    Button btnCrearTarea, btnModificar, btnActualizar;
    String categoria = "";
    String N1, D2, F3, H4, id;
    ListView listView;
    int idOperacion;

    ArrayList<Task> list;
    ArrayAdapter<Task> adapterP;


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
        identificador = findViewById(R.id.id);

        listView = findViewById(R.id.lista);

        btnModificar = findViewById(R.id.btnModificar);
        btnCrearTarea = findViewById(R.id.btnCrearTarea);
        btnActualizar = findViewById(R.id.btnCrearTarea);

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

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(act_prueba.this, MainActivity.class);
                i.putExtra

                //list = getTask();
                adapterP = new ArrayAdapter<>(act_prueba.this, android.R.layout.simple_list_item_1, list);
                listView.setAdapter(adapterP);
                //Toast.makeText(getApplicationContext(), "HOLA", Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Task task = list.get(i);
                /*txtFactor1.setText(String.valueOf(operacion.getFactor1()));
                txtFactor2.setText(String.valueOf(operacion.getFactor2()));
                identificador.setText(String.valueOf(operacion.getId()));*/
            }
        });

        btnModificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                N1 = txtNombre.getText().toString();
                D2 = txtDescripcionTarea.getText().toString();
                F3 = txtFecha.getText().toString();
                H4 = txtHora.getText().toString();
                id = identificador.getText().toString();



                if(!TextUtils.isEmpty(N1) && !TextUtils.isEmpty(D2) && !TextUtils.isEmpty(F3) && !TextUtils.isEmpty(H4) && !TextUtils.isEmpty(categoria)){
                    /*factor1 = Float.parseFloat(f1);
                    factor2 = Float.parseFloat(f2);
                    idOperacion = Integer.parseInt(id);*/



                    if(updateOperacion(idOperacion, N1, D2, F3, H4, categoria)){
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

        //idAutoincremental = idAutoincremental+1;

        return db.insert(TABLA_TAREA, null, content) > 0; /*gregar a la bd*/
    }//Fin addOperacion

    private boolean updateOperacion(int id, String txtNombre, String txtDescripcionTarea, String txtFecha, String txtHora, String categoria){
        ContentValues content  = new ContentValues();
        content.put("txtNombre", txtNombre);
        content.put("txtDescripcionTarea", txtDescripcionTarea);
        content.put("txtFecha", txtFecha );
        content.put("txtHora", txtHora);
        content.put("categoria", categoria);
        return db.update(TABLA_TAREA, content, "id="+id, null)>0;
    }// FIn removeOperacion

    private ArrayList<Task> getTask(){
        Cursor cursor = db.query(TABLA_TAREA, new String[]{"id", "txtNombre", "txtDescripcionTarea", "txtFecha", "txtHora", "categoria"},
                null, null, null, null, "id desc");

        cursor.moveToFirst();// Se mueve el cursor al primer registro
        ArrayList<Task> lista0 = new ArrayList<>();

        while (!cursor.isAfterLast()){
            Task task = new Task();
            task.setId(cursor.getInt(0));
            task.setTituloTarea(cursor.getString(1));
            task.setDescripcion(cursor.getString(2));
            task.setFecha(cursor.getString(3));
            task.setHora(cursor.getString(4));
            task.setCategoria(cursor.getString(5));

            lista0.add(task);
            cursor.moveToNext();
        }//FIn while
        cursor.close();
        return lista0;
    }// Fin getOperacion

    public void limpiar(){
        txtNombre.setText("");
        txtDescripcionTarea.setText("");
        txtFecha.setText("");
        txtHora.setText("");

    }// FIn LImpiar

}