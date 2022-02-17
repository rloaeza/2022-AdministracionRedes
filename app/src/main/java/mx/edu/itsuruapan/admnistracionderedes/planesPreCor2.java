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


    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}