package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class agregar_Inventario extends AppCompatActivity {

    Button BRegistrar;
    Button BEditar;
    Button BEliminar;
    Button BBuscar;
    EditText ETNombre;
    EditText ETDescripcion;
    EditText ETCantidad;
    EditText ETCategoria;
    EditText ETid;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BRegistrar=(Button)findViewById(R.id.BgRegistrar);
        BEditar=(Button)findViewById(R.id.BgEditar);
        BEliminar=(Button)findViewById(R.id.BgEliminar);
        BBuscar=(Button)findViewById(R.id.BgBuscar);

        ETNombre=(EditText)findViewById(R.id.ETgNombre);
        ETDescripcion=(EditText)findViewById(R.id.ETgDescripcion);
        ETCantidad=(EditText)findViewById(R.id.ETgCantidad);
        ETCategoria=(EditText)findViewById(R.id.ETgCategoria);
        ETid=(EditText)findViewById(R.id.ETgId);

        BRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El if verifica que todos los edit Text tengan datos para poder proceder
                if(ETNombre.length()!=0 & ETDescripcion.length()!=0 & ETCantidad.length()!=0 & ETCategoria.length()!=0){
                    NuevoArticulo("https://softortilla.000webhostapp.com/Servicios/insertarAlmacen.php");
                }
                else{ Toast.makeText(getApplicationContext(),"Rellene todos los campos",Toast.LENGTH_SHORT).show(); }
            }
        });

        BBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETid.length()!=0){ Buscar("https://softortilla.000webhostapp.com/Servicios/buscarAlmacen.php?IdAlmacen="+ETid.getText()+""); }
                else{ Toast.makeText(getApplicationContext(),"Ingrese un ID",Toast.LENGTH_SHORT).show(); }
            }
        });

        BEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETNombre.length()!=0 & ETDescripcion.length()!=0 & ETCantidad.length()!=0 & ETCategoria.length()!=0){
                    NuevoArticulo("https://softortilla.000webhostapp.com/Servicios/modificarAlmacen.php?IdAlmacen="+ETid.getText().toString());
                }
                else{ Toast.makeText(getApplicationContext(),"Rellene todos los campos",Toast.LENGTH_SHORT).show(); }
            }
        });

        BEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ETid.length()!=0){ Eliminar("https://softortilla.000webhostapp.com/Servicios/bajaAlmacen.php?IdAlmacen="+ETid.getText().toString()); }
                else{ Toast.makeText(getApplicationContext(),"Ingrese un ID",Toast.LENGTH_SHORT).show(); }
            }
        });
    }

    private void NuevoArticulo(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                ETNombre.setText("");
                ETCantidad.setText("");
                ETDescripcion.setText("");
                ETCategoria.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("nombre",(ETNombre.getText().toString()));
                parametros.put("descripcion",(ETDescripcion.getText().toString()));
                parametros.put("cantidad",(ETCantidad.getText().toString()));
                parametros.put("categoria",(ETCategoria.getText().toString()));
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        //.add(stringRequest);
        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS*2,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(stringRequest);
    }

    private void Buscar(String URL){
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        ETNombre.setText(jsonObject.getString("nombre"));
                        ETDescripcion.setText(jsonObject.getString("descripcion"));
                        ETCantidad.setText(jsonObject.getString("cantidad"));
                        ETCategoria.setText(jsonObject.getString("categoria"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"No encontrado", Toast.LENGTH_SHORT).show();
            }
        }
        );
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void Eliminar(String URL){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "El producto fue eliminado", Toast.LENGTH_SHORT).show();
                ETNombre.setText("");
                ETCantidad.setText("");
                ETDescripcion.setText("");
                ETCategoria.setText("");
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Algo salió mal", Toast.LENGTH_SHORT).show();
            }
        }){
            //@Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String, String>();
                parametros.put("IdAlmacen",(ETid.getText().toString()));
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}