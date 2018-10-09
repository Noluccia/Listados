package pe.edu.upeu.applistas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import pe.edu.upeu.applistas.entidades.Usuario;


public class DetalleUsuarioActivity extends AppCompatActivity {

    TextView campoId,campoNombre,campoApellido,campoEscuela,campoCiclo,campoDireccion,campoTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        campoId = (TextView) findViewById(R.id.campoId);
        campoNombre = (TextView) findViewById(R.id.campoNombre);
        campoApellido = (TextView) findViewById(R.id.campoApellido);
        campoEscuela = (TextView) findViewById(R.id.campoEscuela);
        campoCiclo = (TextView) findViewById(R.id.campoCiclo);
        campoDireccion = (TextView) findViewById(R.id.campoDireccion);
        campoTelefono = (TextView) findViewById(R.id.campoTelefono);

        Bundle objetoEnviado=getIntent().getExtras();
        Usuario user=null;

        if(objetoEnviado!=null){
            user= (Usuario) objetoEnviado.getSerializable("usuario");
            campoId.setText(user.getId().toString());
            campoNombre.setText(user.getNombre().toString());
            campoApellido.setText(user.getApellido().toString());
            campoEscuela.setText(user.getEscuela().toString());
            campoCiclo.setText(user.getCiclo().toString());
            campoDireccion.setText(user.getDireccion().toString());
            campoTelefono.setText(user.getTelefono().toString());

        }

    }
}
