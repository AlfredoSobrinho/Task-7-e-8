package com.generation.task4e5.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.generation.task4e5.R
import com.generation.task4e5.model.Post

class Postadapter : RecyclerView.Adapter<Postadapter.postViewHolder>(){

     private var listapost = emptyList<Post>()

    class postViewHolder (view: View) : RecyclerView.ViewHolder(view){



        val textautor =view.findViewById<TextView>(R.id.textautor)
        val textcategoria =view.findViewById<TextView>(R.id.textcategoria)
        val imageview =view.findViewById<ImageView>(R.id.imageView)
        val texttitulo =view.findViewById<TextView>(R.id.texttitulo)
        val textdescricao =view.findViewById<TextView>(R.id.textdescricao)
        val textdata =view.findViewById<TextView>(R.id.textdata)
        val texthora =view.findViewById<TextView>(R.id.texthora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {

        val layout =LayoutInflater.from(parent.context)

            .inflate(R.layout.card_layout_tarefa, parent, false)

                return postViewHolder(layout)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {

        val post= listapost[position]


        holder.textautor.text= post.autor
        holder.textcategoria.text= post.temas.descricao
        holder.texttitulo.text= post.titulo
        holder.textdescricao.text= post.descricao
        holder.textdata.text= post.data
        holder.texthora.text= post.hora

    }

    override fun getItemCount(): Int {
        return listapost.size
    }

fun setlista(lista: List<Post>){

    listapost = lista
    notifyDataSetChanged()



}





}