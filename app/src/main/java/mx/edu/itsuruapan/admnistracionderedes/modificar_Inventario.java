package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class modificar_Inventario extends AppCompatActivity {

     Button BEditar;
     Button BEliminar;
     Button BBuscar;
     EditText ETNombre;
     EditText ETDescripcion;
     EditText ETCantidad;
     EditText ETCategoria;
     EditText ETid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_inventario);
    }
}