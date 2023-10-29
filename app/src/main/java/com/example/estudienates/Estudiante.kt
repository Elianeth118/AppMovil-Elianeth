package com.example.estudienates

class Estudiante (numControl: String, nombre:String, apellidos: String, semestre: Int ): java.io.Serializable{
    val numControl: String = numControl
    var nombre: String = nombre
    var apellidos: String = apellidos
    var semestre:Int = semestre
}