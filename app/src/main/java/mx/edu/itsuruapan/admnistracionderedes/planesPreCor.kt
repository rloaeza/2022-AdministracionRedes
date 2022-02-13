package mx.edu.itsuruapan.admnistracionderedes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import mx.edu.itsuruapan.admnistracionderedes.databinding.ActivityPlanesPreCorBinding

class planesPreCor : AppCompatActivity(), AdapterView.OnItemClickListener {

    private lateinit var binding : ActivityPlanesPreCorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlanesPreCorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val opciones = resources.getStringArray(R.array.planesPrevencion)

        val adapter =ArrayAdapter(
            this,
            R.layout.list_pd,
            opciones

        )

        with(binding.autoCompleteTextView){
            setAdapter(adapter)
            onItemClickListener = this@planesPreCor

        }

    }

    override fun onItemClick(parent: AdapterView<*>?, viw: View?, position: Int, id: Long) {
      var  item = parent?.getItemAtPosition(position).toString()
        Toast.makeText(this,item,Toast.LENGTH_SHORT).show()
    }
}