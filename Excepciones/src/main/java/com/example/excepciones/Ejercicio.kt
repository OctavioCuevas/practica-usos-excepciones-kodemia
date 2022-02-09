package com.example.excepciones

import java.lang.NullPointerException
import java.lang.NumberFormatException
/*
Instrucciones:
Hacer uso de 4 excepciones
 */
fun main() {
    var language: String
    do {
        language = chooseOption()
    } while (language == null || language == "NaN")
    showLanguageQuestion(language)

    //Prueba para la excepción de lenguaje
    try {
        showLanguageQuestion("prueba")
    } catch (e: LanguageNotFoundException) { //Excepción 4
        println("Lenguaje incorrecto")
    }
}


fun chooseOption(): String {
    val languages = arrayOf("Kotlin", "Java", "PHP", "JavaScript")
    println("Elige un lenguaje de programación")
    for ((index, value) in languages.withIndex()) {
        println("$index) $value")
    }
    var text = readLine()
    text = if (text?.length == 0) null else text
    try {
        println("Seleccionaste la opción ${text!![0]}")
    } catch (e: NullPointerException) { //Excepción 1
        println("Debes seleccionar una opción")
        return "NaN"
    }
    try {
        text?.toInt()
    } catch (e: NumberFormatException) { //Excepción 2
        println("La opción solo puede ser un número")
        return "NaN"
    }
    try {
        val option = languages[text!!.toInt()]
        return option
    } catch (e: ArrayIndexOutOfBoundsException) { //Excepción 3
        println("La opción no es correcta")
        return "NaN"
    }
}

fun showLanguageQuestion(language:String) {
    println("¿Cómo imprimes \"Hola Mundo\" en consola con $language?")
    val text = readLine()
    val answer = when (language) {
        "Kotlin" -> "println(\"Hola Mundo\")"
        "Java" -> "System.out.println(\"Hola Mundo\")"
        "PHP" -> "echo \"Hola Mundo\""
        "JavaScript" -> "console.log(\"Hola Mundo\")"
        else ->
            throw LanguageNotFoundException() //Excepción 4
    }
    if (text.equals(answer)) {
        println("Correcto, ¡Eres un genio!")
    } else {
        println("Incorrecto la respuesta es \"$answer\"")
    }
}