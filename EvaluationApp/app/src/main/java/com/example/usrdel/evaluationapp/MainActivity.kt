package com.example.usrdel.evaluationapp

import android.app.ListActivity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_pantalla_ingreso.setOnClickListener {
            irPantallaIngreso()
        }

        button_pantalla_list.setOnClickListener {

            irPantallaLista()
        }


    }

    fun irPantallaIngreso(){
        val intentIrABotones = Intent(this , IngresoActivity::class.java)
        this.startActivity(intentIrABotones)
    }

    fun irPantallaLista(){
        val intentIrALista = Intent(this , ListActivity::class.java)
        this.startActivity(intentIrALista)
    }

}
