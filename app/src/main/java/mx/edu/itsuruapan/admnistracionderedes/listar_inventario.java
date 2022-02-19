package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class listar_inventario extends AppCompatActivity {

    Button BRListar;
    EditText ETUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_inventario);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        BRListar=(Button) findViewById(R.id.BtnListar);
        ETUsuario=(EditText) findViewById(R.id.ETgUsuario);
    }


}