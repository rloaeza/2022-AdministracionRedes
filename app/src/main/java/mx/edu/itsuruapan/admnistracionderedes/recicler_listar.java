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
import java.util.List;
import java.util.Objects;

public class recicler_listar extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    ArrayList<ListElementListar> elements = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_listar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
        JSONArray json = response.optJSONArray("usuario");
        JSONObject object;

        for(int i = 0; i<json.length();i++){
            try{
                object = Objects.requireNonNull(json).getJSONObject(i);
                elements.add(new ListElementListar(object.optString("IdAlmacen"), object.optString("nombre"), object.optString("descripcion")
                        , object.optString("cantidad"), object.optString("categoria"), object.optString("IdUsuario")));

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        ListAdapterListar listAdapter = new ListAdapterListar(elements,this);
        RecyclerView recyclerView = findViewById(R.id.idrecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

    }
}