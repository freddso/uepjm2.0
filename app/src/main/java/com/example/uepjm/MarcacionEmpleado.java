package com.example.uepjm;

public class MarcacionEmpleado {
    private int id_marcaciones;
    private String nombre;
    private String fecha;
    private String observacion;

    public MarcacionEmpleado(int id_marcaciones, String nombre, String fecha, String observacion) {
        this.id_marcaciones = id_marcaciones;
        this.nombre = nombre;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getId_marcaciones() {
        return id_marcaciones;
    }

    public void setId_marcaciones(int id_marcaciones) {
        this.id_marcaciones = id_marcaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}