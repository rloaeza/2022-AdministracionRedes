package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class recicler_planes extends AppCompatActivity {

    ArrayList <ListaPlanes> elements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recicler_planes);

        init();
    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListaPlanes("plan de emergencia","no pues la neta no supe que mas poner al chile XD "));

    }
}