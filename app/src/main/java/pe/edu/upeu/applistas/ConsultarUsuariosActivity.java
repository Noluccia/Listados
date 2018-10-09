package pe.edu.upeu.applistas;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.upeu.applistas.utilidades.Utilidades;


public class ConsultarUsuariosActivity extends AppCompatActivity {

    EditText campoId,campoNombre,campoApellido,campoEscuela,campoCiclo,campoDireccion,campoTelefono;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn=new ConexionSQLiteHelper(getApplicationContext(),"bd_usuarios",null,1);

        campoId= (EditText) findViewById(R.id.documentoId);
        campoNombre= (EditText) findViewById(R.id.campoNombreConsulta);
        campoApellido= (EditText) findViewById(R.id.campoApellidoConsulta);
        campoEscuela= (EditText) findViewById(R.id.campoEscuelaConsulta);
        campoCiclo= (EditText) findViewById(R.id.campoCicloConsulta);
        campoDireccion= (EditText) findViewById(R.id.campoDireccionConsulta);
        campoTelefono= (EditText) findViewById(R.id.campoTelefonoConsulta);


    }

    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btnConsultar:
//                consultar();
                consultarSql();
                break;
            case R.id.btnActualizar: actualizarUsuario();
                break;
            case R.id.btnEliminar: eliminarUsuario();
                break;
        }

    }

    private void eliminarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario", Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();
    }

    private void actualizarUsuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_APELLIDO,campoApellido.getText().toString());
        values.put(Utilidades.CAMPO_ESCUELA,campoEscuela.getText().toString());
        values.put(Utilidades.CAMPO_CICLO,campoCiclo.getText().toString());
        values.put(Utilidades.CAMPO_DIRECCION,campoDireccion.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO,campoTelefono.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario", Toast.LENGTH_LONG).show();
        db.close();

    }

    private void consultarSql() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_APELLIDO+","+Utilidades.CAMPO_ESCUELA+","+Utilidades.CAMPO_CICLO+","+Utilidades.CAMPO_DIRECCION+","+Utilidades.CAMPO_TELEFONO+
            " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"=? ",parametros);

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoApellido.setText(cursor.getString(1));
            campoEscuela.setText(cursor.getString(2));
            campoCiclo.setText(cursor.getString(3));
            campoDireccion.setText(cursor.getString(4));
            campoTelefono.setText(cursor.getString(5));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};
        String[] campos={Utilidades.CAMPO_NOMBRE,Utilidades.CAMPO_APELLIDO,Utilidades.CAMPO_ESCUELA,Utilidades.CAMPO_CICLO,Utilidades.CAMPO_DIRECCION,Utilidades.CAMPO_TELEFONO};

        try {
            Cursor cursor =db.query(Utilidades.TABLA_USUARIO,campos,Utilidades.CAMPO_ID+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoApellido.setText(cursor.getString(1));
            campoEscuela.setText(cursor.getString(2));
            campoCiclo.setText(cursor.getString(3));
            campoDireccion.setText(cursor.getString(4));
            campoTelefono.setText(cursor.getString(5));
            cursor.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe", Toast.LENGTH_LONG).show();
            limpiar();
        }


    }

    private void limpiar() {
        campoNombre.setText("");
        campoApellido.setText("");
        campoEscuela.setText("");
        campoCiclo.setText("");
        campoDireccion.setText("");
        campoTelefono.setText("");
    }

}
