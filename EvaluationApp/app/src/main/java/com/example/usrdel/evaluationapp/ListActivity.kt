package com.example.usrdel.evaluationapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val adaptadorPerros = ArrayAdapter<Perro>(
                this,
                android.R.layout.simple_list_item_1,
                BaseDatos.imprimirBase()
        )

        lstView.adapter = adaptadorPerros;
        lstView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->

            val seleccionPerro = parent.getItemAtPosition(position) as Perro
            val intentPerroSeleccion = Intent(this, ActualizarBorrarActivity::class.java)
            intentPerroSeleccion.putExtra("Perro", seleccionPerro)
            startActivity(intentPerroSeleccion)
        }

    }

}
