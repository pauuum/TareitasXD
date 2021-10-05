package com.example.tareitasxd;

public class Task {
    private int id = 0;
    private String tituloTarea;
    private String categoria;
    private String fecha;
    private  String hora;
    private String descripcion;


    public Task(int id, String tituloTarea, String categoria, String fecha, String hora, String descripcion) {
        this.id = id;
        this.tituloTarea = tituloTarea;
        this.categoria = categoria;
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
    }

    public Task() {
        this.id = 0;
        this.tituloTarea = "";
        this.categoria = "";
        this.fecha = "";
        this.hora = "";
        this.descripcion = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "Task{" +
                "id=" + id +
                ", tituloTarea='" + tituloTarea + '\'' +
                ", categoria='" + categoria + '\'' +
                ", fecha='" + fecha + '\'' +
                ", hora='" + hora + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
