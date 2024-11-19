package com.example.mvctemperatureconverter

class TemperatureConverterModel {

    //Converts Fahrenheit to Celsius

    fun toCelsius(fahrenheit: Double): Double {
        return (fahrenheit - 32.0) * 5.0/9.0
    }

    //Converts Celsius to Fahrenheit

    fun toFahrenheit(celsius: Double) :Double {
        return (celsius * 9.0/5.0) + 32.0
    }

}