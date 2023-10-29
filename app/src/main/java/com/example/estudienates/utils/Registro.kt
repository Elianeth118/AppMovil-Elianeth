package com.example.estudienates.utils

import com.example.estudienates.Estudiante

class Registro: java.io.Serializable {
    private var estudiantes = ArrayList<Estudiante>()

    fun addList(list: ArrayList<Estudiante>){
        this.estudiantes = list
    }

    fun agregar(estudiante: Estudiante){
        this.estudiantes.add(estudiante)
    }

    fun editar(numeroControl: String, estudiante: Estudiante){
        // Buscar dentro del arreglo por numero de control y guardarle
        // los nuevos valores almacenados en la variable estudiante
    }

    fun eliminar(numeroControl: String){
        // Buscar por numero de control y eliminarlo del arreglo
    }

    fun getEstudiantes(): ArrayList<Estudiante> = this.estudiantes

    fun verEstudiantes(): String{
        var result = ""
        this.estudiantes.forEach{
            result += "${it.numControl} - ${it.nombre} - ${it.apellidos} - ${it.semestre}\n"
        }

        return result
    }

    // Hacer sus operaciones en esta seccion
    companion object {
        var listaEjemplo = ArrayList<Estudiante>()

        fun addStudent(estudiante: Estudiante){
            listaEjemplo.add(estudiante)

        }

        fun verEstudiantesClase(){
            var result = ""
            listaEjemplo.forEach{
                result += "${it.numControl} - ${it.nombre} - ${it.apellidos} - ${it.semestre}\n"
            }

            println(result)
        }

        fun editarClase(numeroControl: String, estudiante: Estudiante){
            // Buscar dentro del arreglo por numero de control y guardarle
            // los nuevos valores almacenados en la variable estudiante
        }

        fun eliminarClase(numeroControl: String){
            // Buscar por numero de control y eliminarlo del arreglo
        }
    }

}