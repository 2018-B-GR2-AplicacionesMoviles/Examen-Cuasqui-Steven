package com.example.usrdel.evaluationapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val arregloPerros =BaseDatos.ListaPerros

        val adaptadorPerros = ArrayAdapter<Perro>(
                this,
                android.R.layout.simple_list_item_1,
                arregloPerros
        )

        val lista =lista1
        lista.adapter = adaptadorPerros

    }

}
