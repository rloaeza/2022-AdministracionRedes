package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class planesPreventivos extends AppCompatActivity implements Response.ErrorListener, Response.Listener<JSONObject> {

    Button btn_insertar;
    Button btn_editar;
    Button btn_eliminar;
    TextView nombre;
    TextView descripccion;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;
    credenciales_Usuario usuarioIngresado = new credenciales_Usuario();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planes_preventivos);

        btn_insertar = findViewById(R.id.btn_agregar);
        btn_editar = findViewById(R.id.btn_editar);
        btn_eliminar = findViewById(R.id.btn_eliminar);
        nombre = findViewById(R.id.nom_planes);
        descripccion = findViewById(R.id.descrip_planes);

        btn_insertar.setOnClickListener(v -> inserter_plan());
        btn_editar.setOnClickListener(v -> editer_plan());

    }

    private void editer_plan() {
        //String url = "https://softortilla.000webhostapp.com/Servicios/modificarPlanes.php?";

       // url = url.replace(" ","%20");

        //request = Volley.newRequestQueue(getApplicationContext());
        //jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);

        //request.add(jsonObjectRequest);

        Intent valor = new Intent(this, recycler_planes.class);
        startActivity(valor);

    }

    /*private void eliminer_plan() {
        String url = "";

        url = url.replace(" ","%20");

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        request.add(jsonObjectRequest);

    }*/

    private void inserter_plan() {
        String url = "https://softortilla.000webhostapp.com/Servicios/insertarPlan.php?nombrePlan="+nombre.getText().toString()+"&descripcionPlan="+descripccion.getText().toString()+"&IdUsuario="+usuarioIngresado.getUsuarioIngresado();//queda pendiente la variable de donde se obtendra el nombre de usuario

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,
                Responseinserter -> Toast.makeText(this,"plan registrado", Toast.LENGTH_SHORT).show(),
                Responseerror -> Toast.makeText(this,"error al registrar plan", Toast.LENGTH_SHORT).show());
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(this,error.toString(),Toast.LENGTH_SHORT);
    }

    @Override
    public void onResponse(JSONObject response) {
        nombre.setText("");
        descripccion.setText("");
    }
}