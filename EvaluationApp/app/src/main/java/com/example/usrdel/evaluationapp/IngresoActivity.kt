package com.example.usrdel.evaluationapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_ingreso.*

class IngresoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ingreso)

        button_guardar.setOnClickListener {

            var nombre:String = editText_nombre.text.toString()
            var raza = editText_raza.text.toString()
            var tamano = editText_tamano.text.toString()
            var fertilidad = editText_fert.text.toString()
            var sexo = editText_sexo.text.toString()





            BaseDatos.agregarPerro(nombre,raza,tamano,fertilidad,sexo)


        }

        button_imprimir.setOnClickListener{

            irPantallaPrincipal()

        }

    }

    fun irPantallaPrincipal(){
        val intentIrABotones = Intent(this , MainActivity::class.java)
        this.startActivity(intentIrABotones)
    }


}
