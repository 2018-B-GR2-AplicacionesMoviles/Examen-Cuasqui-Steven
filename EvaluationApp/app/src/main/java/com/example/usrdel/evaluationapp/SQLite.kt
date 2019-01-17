package com.example.usrdel.evaluationapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class SQLite (context: Context?):
        SQLiteOpenHelper(context, "moviles", null, 1) {
    override fun onCreate(baseDeDatos: SQLiteDatabase?) {
        val crearTablaUsuario = "CREATE TABLE Usuario"+ "( id integer primary key autoincrement," +
                "nombre_usuario varchar(500)," +
                "apellido varchar(500))"
        Log.i("bdd", "Creando Tabla de Usuario")
        baseDeDatos?.execSQL(crearTablaUsuario)
    }

    override fun onUpgrade(db: SQLiteDatabase?, antVersion: Int, nuevaVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun existeUsuarioFormulario(nombre:String?): Usuario {
        val statement = "select * from Usuario where nombre_usuario="+nombre
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        val respuestaUsuario = Usuario(null,null, null)
        if (resultado.moveToFirst()) {

            do {
                respuestaUsuario.id=resultado.getString(0)
                respuestaUsuario.nombre_usuario = resultado.getString(1)
                respuestaUsuario.apellido = resultado.getString(2)
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return respuestaUsuario

    }

    fun cargarDatosUsuarios():ArrayList<Usuario>{

        val statement:String= "select * from "+"Usuario"
        val listaUsuarios = ArrayList<Usuario>()
        val dbReadable = readableDatabase
        val resultado = dbReadable.rawQuery(statement, null)
        if (resultado.moveToFirst()) {

            do {
                val respuestaUsuario = Usuario( null, null, null)
                respuestaUsuario.id=resultado.getString(0)
                respuestaUsuario.nombre_usuario = resultado.getString(1)
                respuestaUsuario.apellido= resultado.getString(2)
                listaUsuarios.add(respuestaUsuario)
                Log.i("database", "Usuarios recuperados")
            } while (resultado.moveToNext())
        }
        resultado.close()
        dbReadable.close()
        return listaUsuarios
    }



    fun crearUsuarioFormulario(usuario:Usuario): Boolean {

        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()
        // Valores de los campos
        cv.put("nombre_usuario", usuario.nombre_usuario)
        cv.put("apellido", usuario.apellido)
        val resultado: Long = dbWriteable
                .insert(
                        "Usuario", // Nombre de la tabla
                        null,
                        cv)
        dbWriteable.close()
        return if (resultado.toInt() == -1) false else true
    }

    fun actualizarUsuarioFormulario(usuario: Usuario): Boolean {
        // Base de datos de escritura
        val dbWriteable = writableDatabase
        val cv = ContentValues()

        // Valores de los campos

        cv.put("nombre_usuario", usuario.nombre_usuario)
        cv.put("apellido", usuario.apellido)

        val resultado = dbWriteable
                .update(
                        "Usuario", // Nombre de la tabla
                        cv, // Valores a actualizarse
                        "id=?", // Where
                        arrayOf(usuario.id) // Parametros
                )

        dbWriteable.close()

        return if (resultado.toInt() == -1) false else true

    }


    fun eliminarUsuarioFormulario(usuario: Usuario): Boolean {

        val dbWriteable = writableDatabase
        val nombreTabla = "Usuario"

        val clausulaWhere = "id = ?"

        val parametros = arrayOf(usuario.id)

        val respuesta = dbWriteable.delete(
                nombreTabla,
                clausulaWhere,
                parametros
        )

        return if (respuesta == -1) false else true

    }



}