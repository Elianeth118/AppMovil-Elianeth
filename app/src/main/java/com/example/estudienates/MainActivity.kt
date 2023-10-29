package com.example.estudienates
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.widget.Toolbar
import com.example.estudienates.utils.Registro

class MainActivity : AppCompatActivity() {
    val crudEst: CRUDEstudiante = CRUDEstudiante()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listStudents = intent.getSerializableExtra("registro") as Registro
        println("Lista de Estudiantes")
        println(listStudents.verEstudiantes())

        val numControlEditText = findViewById<EditText>(R.id.numCrlEditText)
        val nombreEditText = findViewById<EditText>(R.id.editTextNombre)
        val apellidosEditText = findViewById<EditText>(R.id.editTextApellido)
        val semestreEditText = findViewById<EditText>(R.id.editTextSemestre)
        val addButton = findViewById<Button>(R.id.btnRegistrar)
        val listView = findViewById<ListView>(R.id.ListView)

        val estudiantes: MutableList<String> = mutableListOf()

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, estudiantes)
        listView.adapter = adapter

        addButton.setOnClickListener {
            val numControl = numControlEditText.text.toString()
            val nombre = nombreEditText.text.toString()
            val apellidos = apellidosEditText.text.toString()
            val semestre = semestreEditText.text.toString().toIntOrNull() ?: 0

            crudEst.crearEstudiante(numControl, nombre, apellidos, semestre)
            estudiantes.add("$numControl - $nombre $apellidos - Semestre: $semestre")
            listStudents.agregar(Estudiante(numControl, nombre, apellidos, semestre))
            Registro.addStudent(Estudiante(numControl, nombre, apellidos, semestre))

            println(listStudents.verEstudiantes())
            adapter.notifyDataSetChanged()

        }

        /*val verListaButton = findViewById<Button>(R.id.btnVer)
        verListaButton.setOnClickListener {
            val estudiantesArrayList = ArrayList(estudiantes)
            val intent = Intent(this, verActivity::class.java)
            intent.putStringArrayListExtra("estudiantes", estudiantesArrayList)
            startActivity(intent)
        }


        val regresarButton = findViewById<Button>(R.id.btnRegresar)
        regresarButton.setOnClickListener {
            finish()
        }*/
    }
}
