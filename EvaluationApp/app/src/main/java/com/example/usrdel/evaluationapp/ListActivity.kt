package com.example.usrdel.evaluationapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        Log.i("Antes","Base antes")
        var base = SQLite(this)
        Log.i("Despues","Base")
        var listaUsuarios = base.cargarDatosUsuarios()
        Log.i("Carga","Base cargada")

        val layoutManager = LinearLayoutManager(this)
        val rv = recycler_view
        val adaptador = UsuariosAdaptador(listaUsuarios, this, rv)

        recycler_view.layoutManager = layoutManager
        recycler_view.itemAnimator = DefaultItemAnimator()
        recycler_view.adapter = adaptador
        adaptador.notifyDataSetChanged()
    }
}

class UsuariosAdaptador(private val listaUsuarios: List<Usuario>,
                        private val contexto: ListActivity,
                        private val recyclerView: RecyclerView) :
        RecyclerView.Adapter<UsuariosAdaptador.MyViewHolder>() {


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var cedulaTextView: TextView

        init {
            nombreTextView = view.findViewById(R.id.text_view_nombre) as TextView
            cedulaTextView = view.findViewById(R.id.text_view_apellido) as TextView


            // val left = apellido.paddingLeft
            // val top = apellido.paddingTop
            // Log.i("vista-principal", "Hacia la izquierda es $left y hacia arriba es $top")

            val layout = view.findViewById(R.id.relative_layout) as RelativeLayout

            layout
                    .setOnClickListener {
                        val nombreActual = it.findViewById(R.id.text_view_nombre) as TextView

                        Log.i("recycler-view",
                                "El nombre actual es: ${nombreActual.text}")

                    }

            val boton = view.findViewById(R.id.button_ver_info) as Button
        }
    }
            // Definimos el layout
            override fun onCreateViewHolder(
                    parent: ViewGroup,
                    viewType: Int): MyViewHolder {

                val itemView = LayoutInflater
                        .from(parent.context)
                        .inflate(
                                R.layout.list_recycler_layout,
                                parent,
                                false
                        )

                return MyViewHolder(itemView)
            }


            // Llenamos los datos del layout
            override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
                val persona = listaUsuarios[position]

                holder.nombreTextView.setText(persona.nombre_usuario)
                holder.cedulaTextView.setText(persona.apellido)
            }

            override fun getItemCount(): Int {
                return listaUsuarios.size
            }

        }

