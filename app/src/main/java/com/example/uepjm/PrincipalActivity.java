package com.example.uepjm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String nombres="nombre";
   public static final String apellidos="apellido";
    public static final String ci="cedula";
    public static final String nTelefono="telefono";
    public static final String nobservacion= "observacion";
    Button Reportes;
    private final static String REPORTES_URL = "http://192.168.1.9/Biometrico2.2/webapp/View/Reportes.php";
    TextView mNombre, mApellido, mCedula, mTelefono;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

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

        Reportes = findViewById(R.id.btnReportes);
        Reportes.setOnClickListener(this);
    }

    public void onClick (View view){
        Intent intent= new Intent(Intent.ACTION_VIEW);
        switch (view.getId()){
            case R.id.btnReportes:
                intent.setData(Uri.parse(REPORTES_URL));
                startActivity(intent);
                break;
        }


    }
    public void cEmpleados(View view){
        Intent cEmpleados = new Intent(PrincipalActivity.this, EmpleadosActivity.class);
        startActivity(cEmpleados);
    }
    public void cMarcaciones(View view){
        Intent cMarcaciones = new Intent(PrincipalActivity.this, MarcacionesActivity.class);
        startActivity(cMarcaciones);
    }
    public void onSalir(View view){
        Intent salir= new Intent(PrincipalActivity.this,MainActivity.class);
        startActivity(salir);
    }

}

 