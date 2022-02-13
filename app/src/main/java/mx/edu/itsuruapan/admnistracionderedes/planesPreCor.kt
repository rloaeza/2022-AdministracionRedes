package mx.edu.itsuruapan.admnistracionderedes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import mx.edu.itsuruapan.admnistracionderedes.R
import mx.edu.itsuruapan.admnistracionderedes.databinding.ActivityMainBinding

class PlanesPreCor : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_planes_pre_cor)
        setContentView(binding.root)

        val opciones = resources.getStringArray(R.array.planesPrevencion)
        val adapter = ArrayAdapter(
            this,
            R.layout.list_pd,
            opciones
        )


    }
}