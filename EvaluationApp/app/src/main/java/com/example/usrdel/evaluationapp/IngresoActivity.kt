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
            ingresoPerro()
        }

        button_imprimir.setOnClickListener{
            irPantallaPrincipal()
        }
        button_im.setOnClickListener{
            mostrarDatos()
        }

    }

    fun irPantallaPrincipal(){
        limpiar()
        val intentIrABotones = Intent(this , MainActivity::class.java)
        this.startActivity(intentIrABotones)
        this.finish()
    }

    fun mostrarDatos(){
        Log.i("MOSTRAR", BaseDatos.imprimirBase().toString())
        //println(BaseDatos.imprimirBase())

    }

    fun ingresoPerro(){
        var nombre:String = editText_nombre.text.toString()
        var raza = editText_raza.text.toString()
        var tamano = editText_tamano.text.toString()
        var fertilidad = editText_fert.text.toString()
        var sexo = editText_sexo.text.toString()

        val perrito= Perro(nombre=nombre,raza=raza,tamano=tamano,fertilidad=fertilidad,sexo=sexo)
        BaseDatos.agregarPerro(perrito)
        limpiar()
    }

    fun limpiar(){
        editText_nombre.text.clear()
        editText_raza.text.clear()
        editText_tamano.text.clear()
        editText_fert.text.clear()
        editText_sexo.text.clear()
    }

}
