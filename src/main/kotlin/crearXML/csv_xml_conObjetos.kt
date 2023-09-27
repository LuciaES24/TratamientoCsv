package crearXML

import java.io.File
import java.io.FileNotFoundException

fun main() {
    try {
        //Creamos el csv y estraemos su información
        val csv = File("itinerarios.csv").inputStream()
        val bufferedReader = csv.bufferedReader()
        val lines = bufferedReader.readLines()
        if (lines.isEmpty()){
            throw FileNotFoundException()
        }else{
            val tiempoInicio = System.currentTimeMillis()

            //Guardamos la primera línea en la que estarán los nombres de los elementos
            val entities = lines[0].split(",")

            //Creamos el archivo xml
            val xml_csv = File("xml_csv.xml")

            //Creamos un objeto XML
            val xml = XML()
            xml.anadirCabecera()
            xml.anadirPadre("Archivo")

            //Vamos recorriendo las líneas del archivo csv que hemos leido
            for (i in 1..lines.size-1){
                xml.anadirElemento("Registro")
                //Hacemos un split para separar por campos de informacion
                var actualLine = lines[i].split(",")
                //Recorremos los campos y añadimos el elemento hijo junto a la información que le corresponde
                for (x in 0..actualLine.size-1){
                    xml.anadirElementoHijoInformacion("${entities[x]}","${actualLine[x]}")
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
    }catch (e:FileNotFoundException){
        println("El archivo no se ha encontrado o está vacío")
    }
}