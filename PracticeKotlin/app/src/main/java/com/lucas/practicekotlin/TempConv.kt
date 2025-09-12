package com.lucas.practicekotlin

fun main() {
    // Fill in the code.
    printFinalTemperature(
        initialMeasurement = 27.0,
        initialUnit="Celsius",
        finalUnit = "Fahrenheit") { it * 9.0 / 5 + 32 }

    printFinalTemperature(
        initialMeasurement = 350.0,
        initialUnit="Kelvin",
        finalUnit = "Celsius") { it - 273.15 }

    printFinalTemperature(
        initialMeasurement = 10.0,
        initialUnit="Fahrenheit",
        finalUnit = "Kelvin") { 5.0/9 * (it - 32) + 273.15 }
}


fun printFinalTemperature(
    initialMeasurement: Double,
    initialUnit: String,
    finalUnit: String,
    conversionFormula: (Double) -> Double
) {
    val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement)) // two decimal places
    println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
}
