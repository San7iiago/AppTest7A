package com.example.database.utilidades;

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="users";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="firstname";
    public static final String CAMPO_APELLIDO="lastname";
    public static final String CAMPO_EMAIL="email";
    public static final String CAMPO_CONTRASENA="contrasena";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +CAMPO_NOMBRE+" TEXT NOT NULL,"
            +CAMPO_APELLIDO+" TEXT NOT NULL, "
            +CAMPO_EMAIL+" TEXT NOT NULL, "
            +CAMPO_CONTRASENA+" TEXT NOT NULL)";

}
