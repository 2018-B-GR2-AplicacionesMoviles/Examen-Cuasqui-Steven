package com.example.usrdel.evaluationapp

import android.os.Parcelable
import android.util.Log

class BaseDatos{
    companion object {
        var ListaPerros:ArrayList<Perro> = ArrayList()

        fun agregarPerro(perro:Perro){
            ListaPerros.add(perro)


        }
        fun imprimirBase():ArrayList<Perro>{
            return ListaPerros
        }
        fun eliminarPerro(nombre:String){
            for (i in ListaPerros.indices) {
                if(ListaPerros[i].nombre.equals(nombre)){
                    ListaPerros.removeAt(i)
                }
            }
        }

    }


}


