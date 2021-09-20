package com.example.uepjm;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class sesionFragment extends Fragment implements Response.Listener<JSONObject>, Response.ErrorListener {
    RequestQueue rq;
    JsonRequest jrq;
    EditText cajaUser, cajaPwd;
    Button btnConsultar;
    String id_rol;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_sesion, container, false);
        View vista = inflater.inflate(R.layout.fragment_sesion, container, false);
        cajaUser=(EditText)vista.findViewById(R.id.edtUsuario);
        cajaPwd= (EditText)vista.findViewById(R.id.edtPassword);
        btnConsultar=(Button) vista.findViewById(R.id.btnLogin);
        rq= Volley.newRequestQueue(getContext());

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarsesion();
            }
        });
        return vista;
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getContext(), "No se encontro el usuario ", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        User usuario =new User();
        Toast.makeText(getContext(), "Bienvenido "+ cajaUser.getText().toString(), Toast.LENGTH_SHORT).show();
        JSONArray jsonArray = response.optJSONArray("datos");
        JSONObject jsonObject = null;
        try {
            jsonObject = jsonArray.getJSONObject(0);
            usuario.setUser(jsonObject.optString("user"));
            usuario.setPwd(jsonObject.optString("pwd"));
            usuario.setNombre(jsonObject.optString("nombre"));
            usuario.setApellido(jsonObject.optString("apellido"));
            usuario.setCedula(jsonObject.optString("cedula"));
            usuario.setTelefono(jsonObject.optString("telefono"));
            usuario.setObervacion(jsonObject.optString("observacion"));
            id_rol=jsonObject.optString("id_rol");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        if (id_rol.equals("1")){
            Intent intencion = new Intent(getContext(), PrincipalActivity.class);
            intencion.putExtra(PrincipalActivity.nombres, usuario.getNombre());
            intencion.putExtra(PrincipalActivity.apellidos, usuario.getApellido());
            intencion.putExtra(PrincipalActivity.ci, usuario.getCedula());
            intencion.putExtra(PrincipalActivity.nTelefono, usuario.getTelefono());
            startActivity(intencion);
        }else{
            Intent intencion = new Intent(getContext(), SecundaryActivity.class);
            intencion.putExtra(SecundaryActivity.nombres, usuario.getNombre());
            intencion.putExtra(SecundaryActivity.apellidos, usuario.getApellido());
            intencion.putExtra(SecundaryActivity.ci, usuario.getCedula());
            intencion.putExtra(SecundaryActivity.nTelefono, usuario.getTelefono());
            intencion.putExtra(SecundaryActivity.nobservacion, usuario.getObervacion());
            startActivity(intencion);
        }
    }

    private void iniciarsesion(){
        String url="http://192.168.1.9/ProyectoTesis/sesion.php?user="+cajaUser.getText().toString()+
                "&pwd="+cajaPwd.getText().toString();
        jrq = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        rq.add(jrq);

    }
}