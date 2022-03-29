package com.generation.task4e5.model

data class Post(

    val id: Long,
    var autor: String,
    var temas: Temas,
    var imagem:String,
    var titulo:String,
    var descricao:String,
    var data:String,
    var hora:String){
}