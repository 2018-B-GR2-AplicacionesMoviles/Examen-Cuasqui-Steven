package com.example.usrdel.evaluationapp

import android.util.Log

class BaseDatos{
    companion object {
        var ListaPerros:ArrayList<Perro> = ArrayList()

        fun agregarPerro(nombre:String, raza:String, tamano:String,fertilidad:String,sexo:String){
            var perro = Perro(nombre,raza,tamano,fertilidad,sexo)
            ListaPerros.add(perro)


        }


    }
}

class Perro(nombre:String, raza:String, tamano:String,fertilidad:String,sexo:String){

}