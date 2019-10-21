package com.example.database;

import java.util.ArrayList;
import java.util.List;

public class fuente {

    private String nombre;
    private String apellido;
    private String correo;

    public fuente(){

    }

    public fuente(String nombre, String apellido, String correo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCorreo() {
        return correo;
    }
}

