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

public class

MarcacionesActivity extends AppCompatActivity {

    private static final String URL_marcaciones="http://192.168.1.9/ProyectoTesis/ObtenerMarcaciones.php";
    List<Marcaciones> marcacionesList;
    RecyclerView recyclerView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcacion);

        recyclerView2= (RecyclerView)findViewById(R.id.recyclerView2);
        recyclerView2.setHasFixedSize(true);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        marcacionesList = new ArrayList<>();
        loadmarcaciones();
    }

    private void loadmarcaciones(){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_marcaciones,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject marca = array.getJSONObject(i);
                                marcacionesList.add(new Marcaciones(
                                        marca.getInt("id_marcaciones"),
                                        marca.getString("nombre"),
                                        marca.getString("fecha"),
                                        marca.getString("observacion")
                                ));
                            }
                            AdapterMarcaciones adapterMarcaciones =
                                    new AdapterMarcaciones(MarcacionesActivity.this, marcacionesList);
                            recyclerView2.setAdapter(adapterMarcaciones);
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