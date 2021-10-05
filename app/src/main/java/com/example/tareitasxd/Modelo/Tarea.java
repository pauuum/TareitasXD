package com.example.tareitasxd.Modelo;



public class Tarea   {
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
}
