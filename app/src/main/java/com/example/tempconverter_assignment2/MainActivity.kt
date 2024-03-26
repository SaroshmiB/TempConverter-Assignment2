package com.example.tempconverter_assignment2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val temp:EditText=findViewById(R.id.input)
        val btncel:Button=findViewById(R.id.btncelsius)
        val btnfar:Button=findViewById(R.id.btnfar)
        val btnclr: Button =findViewById(R.id.btnclr)

        btncel.setOnClickListener {
           val input=temp.text.toString().toDoubleOrNull()
            if (input != null) temp.setText((input*9/5+32).toString()) else temp.setText("Please enter the temperature")
       }

        btnfar.setOnClickListener {
            val input=temp.text.toString().toDoubleOrNull()
            if (input != null) {
                temp.setText(((input-32)*5/9).toString())
            } else{
                temp.setText("Please enter the temperature")
            }
        }
        btnclr.setOnClickListener {
            temp.setText("")
        }
    }
}


