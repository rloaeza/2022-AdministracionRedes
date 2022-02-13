package mx.edu.itsuruapan.admnistracionderedes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.edu.itsuruapan.admnistracionderedes.R
import mx.edu.itsuruapan.admnistracionderedes.databinding.ActivityMainBinding

class planesPreCor : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_planes_pre_cor)
    }
}