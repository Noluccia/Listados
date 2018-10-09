package pe.edu.upeu.applistas.adaptadores;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import pe.edu.upeu.applistas.R;
import pe.edu.upeu.applistas.entidades.Usuario;


public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder> {

    ArrayList<Usuario> listaUsuario;

    public ListaPersonasAdapter(ArrayList<Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_personas,null,false);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {
        holder.documento.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre());
        holder.apellido.setText(listaUsuario.get(position).getApellido());
        holder.escuela.setText(listaUsuario.get(position).getEscuela());
        holder.ciclo.setText(listaUsuario.get(position).getCiclo());
        holder.direccion.setText(listaUsuario.get(position).getDireccion());
        holder.telefono.setText(listaUsuario.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView documento,nombre,apellido,escuela,ciclo,direccion,telefono;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            documento = (TextView) itemView.findViewById(R.id.textDocumento);
            nombre = (TextView) itemView.findViewById(R.id.textNombre);
            apellido = (TextView) itemView.findViewById(R.id.textApellido);
            escuela = (TextView) itemView.findViewById(R.id.textEscuela);
            ciclo = (TextView) itemView.findViewById(R.id.textCiclo);
            direccion = (TextView) itemView.findViewById(R.id.textDireccion);
            telefono = (TextView) itemView.findViewById(R.id.textTelefono);
        }
    }
}
