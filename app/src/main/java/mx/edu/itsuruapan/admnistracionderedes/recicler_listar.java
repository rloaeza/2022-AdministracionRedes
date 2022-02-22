package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class recicler_listar extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    List<ListElementListar> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_listar);
        buscadorAlmacen();

    }

    public void buscadorAlmacen(){

        String url = "https://softortilla.000webhostapp.com/Servicios/buscarAlmacenListar.php?IdUsuario=fercho";

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, this, this);
        request.add(jsonObjectRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}