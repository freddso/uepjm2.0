package com.example.uepjm;

public class Marcaciones {
    private int id_marcaciones;
    private String nombre;
    private String fecha;
    private String observacion;

    public Marcaciones(int id_marcaciones, String nombre, String fecha, String observacion) {
        this.id_marcaciones = id_marcaciones;
        this.nombre = nombre;
        this.fecha = fecha;
        this.observacion = observacion;
    }

    public int getId_marcaciones() {
        return id_marcaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public String getObservacion() {
        return observacion;
    }
}


