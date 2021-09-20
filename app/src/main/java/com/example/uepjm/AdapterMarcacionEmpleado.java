package com.example.uepjm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterMarcacionEmpleado extends RecyclerView.Adapter<AdapterMarcacionEmpleado.MarcacionEmpleadoViewHolder> {

    private Context mCtx;
    private List<MarcacionEmpleado> marcacionEmpleadoList;

    public AdapterMarcacionEmpleado(Context mCtx, List<MarcacionEmpleado> marcacionEmpleadoList) {
        this.mCtx = mCtx;
        this.marcacionEmpleadoList = marcacionEmpleadoList;
    }

    @NonNull
    @Override
    public MarcacionEmpleadoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.list_marcacion_empleado,null);
        return new MarcacionEmpleadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarcacionEmpleadoViewHolder holder, int position) {
        MarcacionEmpleado marcacionEmpleado= marcacionEmpleadoList.get(position);
        holder.textViewNombreme.setText(marcacionEmpleado.getNombre());
        holder.textViewObservacionme.setText(marcacionEmpleado.getObservacion());
        holder.textViewFechame.setText(marcacionEmpleado.getFecha());
    }

    @Override
    public int getItemCount() {
        return marcacionEmpleadoList.size();
    }

    public class MarcacionEmpleadoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNombreme, textViewObservacionme, textViewFechame;
        public MarcacionEmpleadoViewHolder (View iteView){
            super(iteView);
            textViewNombreme=iteView.findViewById(R.id.txtNombreMe);
            textViewObservacionme=iteView.findViewById(R.id.txtObservacionMe);
            textViewFechame=iteView.findViewById(R.id.txtFechaMe);

        }
    }
}
