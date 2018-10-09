package pe.edu.upeu.applistas.utilidades;

/**
 * Created by CHENAO on 7/05/2017.
 */

public class Utilidades {

    //Constantes campos tabla usuario
    public static final String TABLA_USUARIO="usuario";
    public static final String CAMPO_ID="id";
    public static final String CAMPO_NOMBRE="nombre";
    public static final String CAMPO_APELLIDO="apellido";
    public static final String CAMPO_ESCUELA="escuela";
    public static final String CAMPO_CICLO="ciclo";
    public static final String CAMPO_DIRECCION="direccion";
    public static final String CAMPO_TELEFONO="telefono";

    public static final String CREAR_TABLA_USUARIO="CREATE TABLE " +
            ""+TABLA_USUARIO+" ("+CAMPO_ID+" " +
            "INTEGER, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_APELLIDO+" TEXT,"+CAMPO_ESCUELA+" TEXT,"+CAMPO_CICLO+" TEXT,"+CAMPO_DIRECCION+" TEXT,"+CAMPO_TELEFONO+" TEXT)";

}
