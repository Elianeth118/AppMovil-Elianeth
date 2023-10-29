package com.example.estudienates

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.estudienates.utils.Registro

class MenuActivity : AppCompatActivity() {
    private val estudiantes = mutableListOf<String>()
    var registroEstudiantes: Registro = Registro()
    lateinit var btnEliminar: Button
    lateinit var btnEditar: Button
    lateinit var btnBuscar: Button
    lateinit var btnRegistrar: Button
    lateinit var btnVer: Button

    lateinit var listStudents: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        //var listStudentsActivity = intent?.getSerializableExtra("registro") as ArrayList<Estudiante>

        //this.registroEstudiantes.agregar(Estudiante("16161312", "Agustin", "Garcia", 7))

        btnEliminar = findViewById<Button>(R.id.btnEliminar)
        btnEditar = findViewById<Button>(R.id.btnEditar)
        btnBuscar = findViewById<Button>(R.id.btnBuscar)
        btnRegistrar = findViewById<Button>(R.id.btnRegistrarE)
        btnVer = findViewById<Button>(R.id.btnVerE)
        listStudents = findViewById<Button>(R.id.listStudents)

        this.listStudents.text = this.registroEstudiantes.verEstudiantes()
        var lista = this.registroEstudiantes.getEstudiantes()
        println("Lista de estudiantes: ")
        lista.forEach {
            println("${it.numControl} - ${it.nombre} - ${it.apellidos} - ${it.semestre}\n")
        }
        println("++++++++++++++++++++++++++++++++++++++++++++++")

        this.btnRegistrar.setOnClickListener {
            println("Lista generada ${lista}")
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("registro", this.registroEstudiantes)
            startActivity(intent)
        }

        this.btnVer.setOnClickListener {
            println("Lista de estudiantes en Menu Activity")
            Registro.verEstudiantesClase()
        }

        /*buttonRegistrar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val verButton = findViewById<Button>(R.id.btnMenuVer)
        verButton.setOnClickListener {
            val estudiantesArrayList = ArrayList(estudiantes)
            val intent = Intent(this, verActivity::class.java)
            intent.putStringArrayListExtra("estudiantes", estudiantesArrayList)
            startActivity(intent)
        }*/

    }


}
