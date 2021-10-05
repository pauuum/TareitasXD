package com.example.tareitasxd.Modelo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterTarea extends BaseAdapter {

    Context context;
    ArrayList<Tarea> list;

    public AdapterTarea (Context context, ArrayList<Tarea> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            /*LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_tarea);*/
        }

       /* TextView txt_NombreTarea = view.findViewById(R.id.txt_NombreTarea);
        TextView txt_Categoria = view.findViewById(R.id.lbName);
        TextView txt_Fecha = view.findViewById(R.id.lbLastName);


        txt_NombreTarea.setText(list.get(i).getTituloTarea());
        txt_Categoria.setText(list.get(i).getCategoria());
        txt_Fecha.setText(list.get(i).getFecha());*/

        return view;
    }
}

