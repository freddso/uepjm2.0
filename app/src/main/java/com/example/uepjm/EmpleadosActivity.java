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

public class EmpleadosActivity extends AppCompatActivity {

    private static final String URL_empleados="http://192.168.1.9/proyectoTesis/ConsultaEmpleados.php";
    List<Empleados> empleadosList;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleados);

        recyclerView=(RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        empleadosList = new ArrayList<>();
        loadempleados();
    }

    private void loadempleados(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_empleados,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject emple = array.getJSONObject(i);
                                empleadosList.add(new Empleados(
                                        emple.getInt("id_empleado"),
                                        emple.getString("nombre"),
                                        emple.getString("apellido"),
                                        emple.getString("cedula"),
                                        emple.getString("observacion"),
                                        emple.getString("imagen")
                                ));
                            }
                            AdapterEmpleados adapter =
                                    new AdapterEmpleados(EmpleadosActivity.this, empleadosList);
                            recyclerView.setAdapter(adapter);
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