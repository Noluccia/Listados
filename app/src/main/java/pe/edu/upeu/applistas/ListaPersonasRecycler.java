package pe.edu.upeu.applistas;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


import pe.edu.upeu.applistas.adaptadores.ListaPersonasAdapter;
import pe.edu.upeu.applistas.entidades.Usuario;
import pe.edu.upeu.applistas.utilidades.Utilidades;

public class ListaPersonasRecycler extends AppCompatActivity {

    ArrayList<Usuario> listaUsuario;
    RecyclerView recyclerViewUsuarios;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_personas_recycler);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        listaUsuario=new ArrayList<>();

        recyclerViewUsuarios= (RecyclerView) findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        ListaPersonasAdapter adapter=new ListaPersonasAdapter(listaUsuario);
        recyclerViewUsuarios.setAdapter(adapter);

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        Usuario usuario=null;
       // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new Usuario();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setApellido(cursor.getString(2));
            usuario.setEscuela(cursor.getString(3));
            usuario.setCiclo(cursor.getString(4));
            usuario.setDireccion(cursor.getString(5));
            usuario.setTelefono(cursor.getString(6));

            listaUsuario.add(usuario);
        }
    }

    private void llenarListaUsuarios() {
        listaUsuario.add(new Usuario(1,"Cristian","Suarez","Ambiental","V","Chosica","548526"));
        listaUsuario.add(new Usuario(2,"Norma","Riquelme","Sistemas","VI","Chaclacayo","548526"));

    }
}
