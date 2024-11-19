package com.example.mvctemperatureconverter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Make the object of the model class
        val temperatureConverterModel = TemperatureConverterModel()

        //get the reference of the UI elements defined in the XML file

        val inputTemperature = findViewById<EditText>(R.id.inputTemperatureEditText)
        val toCelsiusRadioButton = findViewById<RadioButton>(R.id.toCelsiusRadioButton)
        val toFahrenheitRadioButton = findViewById<RadioButton>(R.id.toFahrenheitRadioButton)
        val convertButton: Button = findViewById(R.id.convertButton)
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        //setup the onclicklistener for convert button
        convertButton.setOnClickListener {
            val input = inputTemperature.text.toString()

            if(input.isNotEmpty()) {
                val temperature = input.toDouble()
                val result: Double

                if(toCelsiusRadioButton.isChecked) {

                    result = temperatureConverterModel.toCelsius(temperature)
                    resultTextView.text = "Result: $result"

                } else if (toFahrenheitRadioButton.isChecked) {

                    result = temperatureConverterModel.toFahrenheit(temperature)
                    resultTextView.text = "Result: $result"

                } else {
                    Toast.makeText(this, "Please select a conversion type", Toast.LENGTH_SHORT).show()
                }


            } else {
                Toast.makeText(this, "Please enter the temperature", Toast.LENGTH_LONG).show()
            }

        }
    }
}