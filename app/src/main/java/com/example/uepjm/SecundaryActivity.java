package com.example.uepjm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecundaryActivity extends AppCompatActivity {
    public static final String nombres="nombre";
    public static final String apellidos="apellido";
    public static final String ci="cedula";
    public static final String nTelefono="telefono";
    public static final String nobservacion= "observacion";

    TextView mNombre, mApellido, mCedula, mTelefono, mObservacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundary);

        mNombre =(TextView)findViewById(R.id.txtNombre);
        String nombre=getIntent().getStringExtra("nombre");
        mNombre.setText(nombre);

        mApellido = (TextView)findViewById(R.id.txtapellido);
        String apellido=getIntent().getStringExtra("apellido");
        mApellido.setText(apellido);

        mCedula = (TextView)findViewById(R.id.txtCedula);
        String cedula=getIntent().getStringExtra("cedula");
        mCedula.setText(cedula);

        mTelefono=(TextView)findViewById(R.id.txttelefono);
        String telefono=getIntent().getStringExtra("telefono");
        mTelefono.setText(telefono);

        mObservacion=(TextView)findViewById(R.id.txtobservacion);
        String observacion=getIntent().getStringExtra("observacion");
        mObservacion.setText(observacion);
    }

    public void onOff (View view){
        Intent onOff= new Intent(SecundaryActivity.this,MainActivity.class);
        startActivity(onOff);
    }

    public void cMarcacionE(View view){
        System.out.println("entr en marcacion 1");
        String meCedula;
        meCedula= mCedula.getText().toString();
        Intent cMarcacionE = new Intent(SecundaryActivity.this, MarcacionEmpleadoActivity.class);
        cMarcacionE.putExtra("mCedula",meCedula);

        startActivity(cMarcacionE);
        System.out.println("entr en marcacio 2n");
    }
}