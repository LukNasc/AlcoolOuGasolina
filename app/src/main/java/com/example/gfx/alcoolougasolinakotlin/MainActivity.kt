package com.example.gfx.alcoolougasolinakotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var buttonVerifica: Button
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonVerifica = btnVerifica
        textResultado = tvResultado



        buttonVerifica.setOnClickListener {
            val editTextAlcool = etAlcool.text.toString()
            val editTextGasolina = etGasolina.text.toString()

            if (editTextAlcool.equals("") || editTextGasolina.equals("")){
                Toast.makeText(applicationContext, "Nenhum campo pode estar vazío", Toast.LENGTH_SHORT).show();
            }else{
                fazCalculo(editTextAlcool, editTextGasolina)
            }
        }

    }

    fun fazCalculo(alcool: String, gasolina: String){

        //Convertendo valores
        val valorAlcool = alcool.toDouble()
        val valorGasolina = gasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if(resultadoPreco >= 0.7){
            textResultado.setText("Melhor utilizar gasolina")
        }else{
            textResultado.setText("Melhor utilizar alcool")
        }
    }
}
