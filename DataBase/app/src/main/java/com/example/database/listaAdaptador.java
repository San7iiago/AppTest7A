package com.example.database;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class listaAdaptador extends RecyclerView.Adapter<listaAdaptador.UserViewHolder> {
    public List<fuente> usuarioLista;

    public listaAdaptador(List<fuente> usuarioLista) { this.usuarioLista = usuarioLista; }

    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_layout,viewGroup,false);

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder viewHolder, int i) {
        viewHolder.id = usuarioLista.get(i).getId();
        viewHolder.nombre.setText(usuarioLista.get(i).getNombre());
        viewHolder.apellido.setText(usuarioLista.get(i).getApellido());
        viewHolder.correo.setText(usuarioLista.get(i).getCorreo());
    }

    public int getItemCount() {
        return usuarioLista.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        TextView nombre, apellido, correo;
        int id;

        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.lname);
            apellido = (TextView) itemView.findViewById(R.id.lapellido);
            correo = (TextView) itemView.findViewById(R.id.lcorreo);
        }
    }

}
