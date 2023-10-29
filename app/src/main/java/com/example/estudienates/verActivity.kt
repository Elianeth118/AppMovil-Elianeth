package com.example.estudienates

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class verActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver)

        val listView = findViewById<ListView>(R.id.listaVer)

        val estudiantes = intent.getStringArrayListExtra("estudiantes")

        val estudiantesList: MutableList<String> = mutableListOf()
        if (estudiantes != null) {
            estudiantesList.addAll(estudiantes)
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, estudiantesList)
        listView.adapter = adapter


    }
}