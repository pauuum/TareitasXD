package com.example.tareitasxd.Modelo;


import android.os.Parcel;
import android.os.Parcelable;

public class Tarea implements Parcelable {
    private String tituloTarea;
    private String categoria;
    private String fecha;
    private  String hora;
    private String descripcion;

    public Tarea(String tituloTarea, String categoria, String fecha, String hora, String descripcion) {
        this.tituloTarea = tituloTarea;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Tarea() {
        this.tituloTarea = "";
        this.categoria = "";
        this.fecha = "";
        this.hora = "";
        this.descripcion = "";
    }

    protected Tarea (Parcel in) {
        tituloTarea = in.readString();
        categoria = in.readString();
        fecha = in.readString();
        hora = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Tarea> CREATOR = new Creator<Tarea>() {
        @Override
        public Tarea createFromParcel(Parcel in) {
            return new Tarea(in);
        }

        @Override
        public Tarea[] newArray(int size) {
            return new Tarea[size];
        }
    };

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "tituloTarea='" + tituloTarea + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tituloTarea);
        parcel.writeString(categoria);
        parcel.writeString(fecha);
        parcel.writeString(hora);
        parcel.writeString(descripcion);
    }
}
