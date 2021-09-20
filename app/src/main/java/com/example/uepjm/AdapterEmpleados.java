package com.example.uepjm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterEmpleados extends RecyclerView.Adapter<AdapterEmpleados.EmpleadoViewHolder> {

    private Context mCtx;
    private List<Empleados> empleadoList;

    public AdapterEmpleados(Context mCtx, List<Empleados> empleadoList ){
        this.mCtx = mCtx;
        this.empleadoList=empleadoList;
    }

    @NonNull
    @Override
    public EmpleadoViewHolder onCreateViewHolder (ViewGroup parent, int viewType){
        LayoutInflater inflater= LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_layout, null);
        return new EmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder (EmpleadoViewHolder holder, int  position){
        Empleados emple = empleadoList.get(position);
        holder.textViewNombre.setText("Nombre: "+emple.getNombre());
        holder.textViewApellido.setText("Apellido: "+emple.getApellido());
        holder.textViewCedula.setText("Cedula: "+emple.getCedula());
        holder.textViewObservacion.setText("Observacion: "+ emple.getObservacion());
        Glide.with(mCtx)
                .load(emple.getImagen())
                .into(holder.imageView);
    }

    @Override
    public  int getItemCount() {return empleadoList.size(); }

    static class EmpleadoViewHolder extends RecyclerView.ViewHolder{
        TextView textViewNombre,textViewApellido, textViewCedula, textViewObservacion ;
        ImageView imageView;

        public EmpleadoViewHolder(View itemView){
            super(itemView);

            textViewNombre=itemView.findViewById(R.id.textNombre);
            textViewApellido=itemView.findViewById(R.id.textApellido);
            textViewCedula=itemView.findViewById(R.id.textCedula);
            textViewObservacion=itemView.findViewById(R.id.textObservacion);
            imageView=itemView.findViewById(R.id.imageView);

        }
    }
}


