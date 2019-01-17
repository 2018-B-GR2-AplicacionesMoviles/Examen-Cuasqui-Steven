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
        val intent= Intent(this,ListActivity::class.java)
        startActivity(intent)

    }

    fun ingresoPerro(){
        var nombre:String = editText_nombre.text.toString()
        var apellido = editText_raza.text.toString()

        val nUsuario= Usuario(id="1",nombre_usuario= editText_nombre.text.toString(),apellido=editText_raza.text.toString())
        var base = SQLite(this)
        base.crearUsuarioFormulario(nUsuario)
        Log.i("BDD","Usuario creado con éxito")

        limpiar()
    }

    fun limpiar(){
        editText_nombre.text.clear()
        editText_raza.text.clear()

    }

}
