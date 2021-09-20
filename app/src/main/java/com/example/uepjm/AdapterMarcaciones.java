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

public class AdapterMarcaciones extends RecyclerView.Adapter<AdapterMarcaciones.MarcacionViewHolder> {

    private Context mCtx;
    private List<Marcaciones> marcacionList;

    public AdapterMarcaciones(Context mCtx, List<Marcaciones> marcacionList) {
        this.mCtx = mCtx;
        this.marcacionList = marcacionList;
    }

    @NonNull
    @Override
    public MarcacionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view= inflater.inflate(R.layout.list_marcacion, null);
        return new MarcacionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MarcacionViewHolder holder, int position) {
        Marcaciones marca = marcacionList.get(position);
        holder.textViewNombre.setText(marca.getNombre());
        holder.textViewFecha.setText(marca.getFecha());
        holder.textViewObservacion.setText(marca.getObservacion());
    }

    @Override
    public int getItemCount() { return marcacionList.size(); }

    static class MarcacionViewHolder extends  RecyclerView.ViewHolder{
        TextView textViewNombre, textViewObservacion, textViewFecha;
        public MarcacionViewHolder (View itemView){
            super(itemView);
            textViewNombre=itemView.findViewById(R.id.txtNombreM);
            textViewFecha=itemView.findViewById(R.id.txtFechaM);
            textViewObservacion=itemView.findViewById(R.id.txtObservacionM);
        }
    }
}
