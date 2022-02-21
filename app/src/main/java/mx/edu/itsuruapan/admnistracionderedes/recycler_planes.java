package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
    ArrayList <ListaPlanes> elements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_planes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListaPlanes("plan de emergencia","no pues la neta no supe que mas poner al chile XD "));
        buscadorPlanes();

        listAdapter listAdapter = new listAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.list_recicler_planes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }

    public void buscadorPlanes(){
        String url = "https://softortilla.000webhostapp.com/Servicios/buscarPlan.php?IdPlan=%22Rossnok%22";

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);//preparacion de la sentencia
        request.add(jsonObjectRequest);// ejecucion de la sentencia y obtencion de la respuesta por parte del web service

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        JSONArray json = response.optJSONArray("usuario");//instancia del array de tipo json que almacenara los datos obtenidos de la respues del web service
        JSONObject objet;//instancia de un objeto de tipo json

        //obtencion de los valores del plan y posterior muestra en los recycler//
       for(int i = 0;i < json.length();i++){
           try {
               objet = Objects.requireNonNull(json).getJSONObject(i);
               elements.add(new ListaPlanes(objet.optString("asdad"),objet.optString("adasd")));

           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
    }
}