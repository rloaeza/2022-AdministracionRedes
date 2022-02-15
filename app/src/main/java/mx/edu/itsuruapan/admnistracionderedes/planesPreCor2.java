package mx.edu.itsuruapan.admnistracionderedes;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import androidx.appcompat.app.AppCompatActivity;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import kotlin.jvm.internal.Intrinsics;
import mx.edu.itsuruapan.admnistracionderedes.databinding.ActivityPlanesPreCor2Binding;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;


public final class planesPreCor2 extends AppCompatActivity implements OnItemClickListener, Response.Listener<JSONObject>, Response.ErrorListener {

    private ActivityPlanesPreCor2Binding binding;
    String item;
    RequestQueue request;
    JsonObjectRequest jsonObjectRequest;


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlanesPreCor2Binding var10001 = ActivityPlanesPreCor2Binding.inflate(this.getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(var10001, "ActivityPlanesPreCorBind…g.inflate(layoutInflater)");
        this.binding = var10001;
        var10001 = this.binding;

        this.setContentView(var10001.getRoot());
        String[] opciones = this.getResources().getStringArray(R.array.planesPrevencion);
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                R.layout.list_pd,
                opciones);
        ActivityPlanesPreCor2Binding var7 = this.binding;
        if (var7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        }

        AutoCompleteTextView var4 = var7.autoCompleteTextView;
        var4.setAdapter(adapter);
        var4.setOnItemClickListener(this);
    }

    public void onItemClick(@Nullable AdapterView parent, @Nullable View viw, int position, long id) {
         item = String.valueOf(parent != null ? parent.getItemAtPosition(position) : null);
        Toast.makeText(
                this,
                 item,
                0
        ).show();

        if(item.equals("pftres")){
            eliminar_plan();
        }
    }

    public void eliminar_plan(){

        String url = "https://aquarossnok.000webhostapp.com/biblioteca/eliminar_usuario.php?id_usuario=3";//sentencia que se ejecutara en el web service

        request = Volley.newRequestQueue(getApplicationContext());
        jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null , ResponseEliminar -> Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show()
                ,ErrorEliminar -> Toast.makeText(this, "Error durante el proceso", Toast.LENGTH_SHORT).show());//ejecucion de la sentencia
        request.add(jsonObjectRequest);//obtencion de la respuesta por parte del web host (tiene que ser en formato json)

    }

    @Override
    public void onResponse(JSONObject response) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
