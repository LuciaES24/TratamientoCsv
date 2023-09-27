package crearXML

import com.github.doyaaaaaken.kotlincsv.client.CsvReader
import java.io.File

fun main(){
    val tiempoInicio = System.currentTimeMillis()

    val csv = File("itinerarios.csv")
    val csvReader = CsvReader()
    val contenido = csvReader.readAllWithHeader(csv)

    //Creamos el archivo xml
    val xml_csv = File("xml_csv.xml")

    //Creamos un objeto XML
    val xml = XML()
    xml.anadirCabecera()
    xml.anadirPadre("Archivo")

    //Recorremos la lista que hemos extraido del csv
    for (linea in contenido){
        xml.anadirElemento("Registro")
        //Recorremos el diccionario de cada línea y lo añadimos como elemento hijo
        for ((key, value) in linea){
            xml.anadirElementoHijoInformacion(key,value)
        }
        xml.cierreElemento("Registro")
    }
    xml.cierrePadre("Archivo")

    //Escribimos en el archivo xml que creamos previamente
    xml_csv.writeText(xml.lineas_xml)

    val tiempoFin = System.currentTimeMillis()
    val tiempoTotal = tiempoFin-tiempoInicio
    println("El tiempo es de "+ tiempoTotal + " milisegundos")
}