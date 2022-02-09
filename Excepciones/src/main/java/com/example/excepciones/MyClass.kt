package com.example.excepciones

import java.io.File
import java.io.FileNotFoundException
import java.io.FileReader
import java.lang.ArithmeticException
import java.lang.NullPointerException
import java.lang.NumberFormatException

fun main() {
    arithmeticException()
    nullPointerException()
    stringIndexOutOfBoundsException()
    fileNotFoundException()
    numberFormatException()
    arrayIndexOutOfBoundException()
}

fun arithmeticException() {
    try {
        val a = 30
        val b = 0
        val c = a/b
        println("Resultado = $c")
    } catch (e: ArithmeticException) {
        println(e.message)
        println("Una división no puede ser entre 0")
    }
}

fun nullPointerException(){
    try {
        val a: String? = null
        println(a!![0])
    } catch (e: NullPointerException) {
        println(e.message)
        println("La variable es nula")
    }
}

fun stringIndexOutOfBoundsException() {
    try {
        val a = "Estoy escalando en el Pico del Aguila"
        val b = a.length
        println(b)
        val c = a[39]
        println(c)
    } catch (e: StringIndexOutOfBoundsException) {
        println(e.message)
        println("Indice de la cadena fuera del rango")
    }
}

fun fileNotFoundException() {
    try {
        val file = File("C://archivo.txt")
        println(file.name)
        val fileReader = FileReader(file)
    } catch (e: FileNotFoundException) {
        println(e.message)
        println("No se encontró el archivo")
    }
}

fun numberFormatException() {
    try {
        val numero = "aki".toInt()
        println(numero)
    } catch (e: NumberFormatException) {
        println(e.message)
        println("Número incorrecto")
    }
}

fun arrayIndexOutOfBoundException() {
    try {
        val a = IntArray(5)
        a[6] = 9
    } catch (e: ArrayIndexOutOfBoundsException) {
        println(e.message)
        println("Index incorrecto")
    }
}
