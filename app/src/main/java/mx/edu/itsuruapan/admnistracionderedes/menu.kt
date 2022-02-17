package mx.edu.itsuruapan.admnistracionderedes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class menu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

    }

    fun IrAInventario(view: View?) {
        val oth = Intent(applicationContext, agregar_Inventario::class.java)
        startActivity(oth)
    }
}