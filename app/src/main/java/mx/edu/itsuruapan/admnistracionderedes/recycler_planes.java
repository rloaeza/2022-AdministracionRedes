package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Objects;

public class recycler_planes extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ArrayList <ListaPlanes> elements = new ArrayList<>();
    credenciales_Usuario usuarioIngresado = new credenciales_Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_planes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buscadorPlanes();


    }

    public void buscadorPlanes(){
        String url = "https://softortilla.000webhostapp.com/Servicios/buscarPlan.php?IdUsuario="+usuarioIngresado.getUsuarioIngresado();

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("usuario");
        JSONObject objet;

        for(int i = 0; i<json.length();i++){
           try {
               objet = Objects.requireNonNull(json).getJSONObject(i);
               elements.add(new ListaPlanes(objet.optString("nombrePlan"),objet.optString("descripcionPlan")));

           } catch (JSONException e) {
               e.printStackTrace();
           }

        }

        listAdapter listAdapter = new listAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.list_recicler_planes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}