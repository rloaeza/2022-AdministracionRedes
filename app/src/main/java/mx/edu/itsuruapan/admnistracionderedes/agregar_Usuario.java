package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

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
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class agregar_Usuario extends AppCompatActivity {

    Button BRegistrar;
    EditText ETEmail;
    EditText ETPass;
    EditText ETPass2;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_usuario);

        BRegistrar=(Button)findViewById(R.id.BgRegistro);
        ETEmail=(EditText)findViewById(R.id.ETgCorreo);
        ETPass=(EditText)findViewById(R.id.ETgContrasena);
        ETPass2=(EditText)findViewById(R.id.ETgContrasena2);

        BRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //El if verifica que todos los edit Text tengan datos para poder proceder
                if(ETEmail.length()!=0 & ETPass.length()!=0 & ETPass2.length()!=0){
                    if(ETPass.getText().toString().equals(ETPass2.getText().toString()) ){
                        NuevoUsuario("https://softortilla.000webhostapp.com/Servicios/usuariosAlta.php");
                    }
                    else{ Toast.makeText(getApplicationContext(),"Las contraseñas no coinciden",Toast.LENGTH_SHORT).show(); }
                }
                else{ Toast.makeText(getApplicationContext(),"Rellene todos los campos",Toast.LENGTH_SHORT).show(); }
            }
        });
    }
//
    private void NuevoUsuario(String URL) {
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Operación exitosa", Toast.LENGTH_SHORT).show();
                ETEmail.setText("");
                ETPass.setText("");
                ETPass2.setText("");
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
                parametros.put("email",(ETEmail.getText().toString()));
                parametros.put("contrasena",(ETPass.getText().toString()));
                return parametros;
            }
        };
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        //.add(stringRequest);
        //stringRequest.setRetryPolicy(new DefaultRetryPolicy(DefaultRetryPolicy.DEFAULT_TIMEOUT_MS*2,DefaultRetryPolicy.DEFAULT_MAX_RETRIES,DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        //VolleySingleton.getIntanciaVolley(getContext()).addToRequestQueue(stringRequest);
    }

}