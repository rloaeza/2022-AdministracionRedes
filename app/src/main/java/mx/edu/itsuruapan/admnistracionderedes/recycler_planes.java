package mx.edu.itsuruapan.admnistracionderedes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class recycler_planes extends AppCompatActivity {

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

        listAdapter listAdapter = new listAdapter(elements,this);
        RecyclerView recyclerView = findViewById(R.id.list_recicler_planes);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }
}