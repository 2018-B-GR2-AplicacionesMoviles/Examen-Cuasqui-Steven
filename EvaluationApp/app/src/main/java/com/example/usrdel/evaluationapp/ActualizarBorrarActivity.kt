package com.example.usrdel.evaluationapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_actualizar_borrar.*

class ActualizarBorrarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_borrar)
        val Perropasado = intent.getParcelableExtra<Perro>("Perro")
        editText_nombreperro.setText(Perropasado.nombre.toString())
        editText_razaperro.setText(Perropasado.raza.toString())

        button_borrar.setOnClickListener { eliminar() }


    }

    fun eliminar(){
        //BaseDatos.eliminarPerro(editText_nombreperro.text.toString())
    }
}
