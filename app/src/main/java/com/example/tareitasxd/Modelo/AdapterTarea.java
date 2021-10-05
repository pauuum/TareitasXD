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
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.item_tarea);
        }
        TextView lbNombre = view.findViewById(R.id.lbUser);
        TextView lbCarnet = view.findViewById(R.id.lbName);
        TextView lbCarrera = view.findViewById(R.id.lbLastName);


        lbNombre.setText(list.get(i).getUser());
        lbCarnet.setText(list.get(i).getName());
        lbCarrera.setText(list.get(i).getLastName());


        return view;
    }
}

