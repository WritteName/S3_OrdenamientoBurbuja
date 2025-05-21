package com.example.s3_ordenamientoburbuja

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val No01 = findViewById<EditText>(R.id.etVal01)
        val No02 = findViewById<EditText>(R.id.etVal02)
        val No03 = findViewById<EditText>(R.id.etVal03)
        val No04 = findViewById<EditText>(R.id.etVal04)
        val No05 = findViewById<EditText>(R.id.etVal05)
        val BtnOrd = findViewById<Button>(R.id.btnOrdenar)
        val tvResult = findViewById<TextView>(R.id.tvResultado)

        var tmp: Double = 0.0

        BtnOrd.setOnClickListener {
            val A = No01.text.toString().trim().toDoubleOrNull() // 14
            val B = No02.text.toString().trim().toDoubleOrNull() // 10
            val C = No03.text.toString().trim().toDoubleOrNull() // 20
            val D = No04.text.toString().trim().toDoubleOrNull() // 4
            val E = No05.text.toString().trim().toDoubleOrNull() // 1

            if (A != null && B != null && C != null && D != null && E != null) {
                val ListaBur = mutableListOf(A, B, C, D, E)

                for (i in 0 until ListaBur.size - 1) {
                    for (j in 0 until ListaBur.size - i - 1) {
                        if (ListaBur[j] > ListaBur[j + 1]) {
                            val tmp = ListaBur[j]
                            ListaBur[j] = ListaBur[j + 1]
                            ListaBur[j + 1] = tmp
                        }
                    }
                }
                tvResult.text = "[$ListaBur]"
            } else {
                tvResult.text = "Datos Incorrectos"
            }
        }
    }
}