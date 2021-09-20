package com.example.uepjm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MarcacionEmpleadoActivity extends AppCompatActivity {

    List<MarcacionEmpleado> marcacionempleadosList;
    RecyclerView merecyclerview;

    public static final String ci="cedula";
    public static String cedula;
    private static final String URL_marcaciones_empleado="http://192.168.1.9/ProyectoTesis/ObtenerMarcacionEmpleado.php?cedula="+cedula;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcacion_empleado);



        merecyclerview=(RecyclerView)findViewById(R.id.merecyclerview);
        merecyclerview.setHasFixedSize(true);
        merecyclerview.setLayoutManager(new LinearLayoutManager(this));

        marcacionempleadosList = new ArrayList<>();
        loadmarcacionempleado();
    }
    private void loadmarcacionempleado(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_marcaciones_empleado,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject marcae = array.getJSONObject(i);
                                cedula=marcae.optString("cedula");
                                marcacionempleadosList.add(new MarcacionEmpleado(
                                        marcae.getInt("id_marcaciones"),
                                        marcae.getString("nombre"),
                                        marcae.getString("fecha"),
                                        marcae.getString("observacion")


                                ));
                            }
                            AdapterMarcacionEmpleado
                                    adapterMarcacionEmpleado =
                                    new AdapterMarcacionEmpleado(MarcacionEmpleadoActivity.this, marcacionempleadosList);
                            merecyclerview.setAdapter(adapterMarcacionEmpleado);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }
}

