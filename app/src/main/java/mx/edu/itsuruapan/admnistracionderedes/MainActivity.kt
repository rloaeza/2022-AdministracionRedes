package mx.edu.itsuruapan.admnistracionderedes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

// Roberto Loaeza: telegram: 4521181954     t.me/rloaeza
class MainActivity : AppCompatActivity() {
    //Miguel Morfin
    //Alberto Losuna
    //Carolina Pirita
    //Cristian Fonseca
    //Fernando Eduardo
    //Sergio Rosas
    //ISAAC NARANJO
    //Josue Garcia

    //Declarar los objetos

    private var ETUser: EditText? = null
    private var ETPass: EditText? = null
    //private val BIngresar: Button? = null

    //private lateinit var appBarConfiguration: AppBarConfiguration
    //private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ETUser = findViewById<View>(R.id.ETgUser) as EditText
        ETPass = findViewById<View>(R.id.ETgPass) as EditText

        /*var valor = Intent(this, recicler_listar::class.java);
        startActivity(valor);*/

    }

    //Método para validar usuarios
    private fun validarUsuario(URL: String) {
        val stringRequest: StringRequest = object : StringRequest(
            Method.POST, URL,
            Response.Listener { response ->
                if (!response.isEmpty()) {
                    val oth = Intent(applicationContext, menu::class.java)
                    startActivity(oth)
                    ETPass?.setText("");
                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Usuario o contraseña incorrecta",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this@MainActivity,
                    error.toString(),
                    Toast.LENGTH_SHORT
                ).show()
            }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): Map<String, String>? {
                val parametros: MutableMap<String, String> = HashMap()
                parametros["email"] = ETUser!!.text.toString()
                parametros["contrasena"] = ETPass!!.text.toString()
                return parametros
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    //Metodo del boton, llama a validarUsuario()
    fun MetodoIngresar(view: View?) {
        //pasar los valores de ETUser y ETPass a variables
        val User = ETUser!!.text.toString()
        val Pass = ETPass!!.text.toString()

        //Verifica que los campos tengan algun valor
        if (User.length != 0 && Pass.length != 0) {
            validarUsuario("https://softortilla.000webhostapp.com/Servicios/validarUsuario.php")
        } //Llave del if
        else {
            Toast.makeText(this, "Ingrese usuario y contraseña", Toast.LENGTH_LONG).show()
        }
    }

    fun IrARegistrar(view: View?) {
        val oth = Intent(applicationContext, agregar_Usuario::class.java)
        startActivity(oth)
    }
}