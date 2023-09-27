package crearXMLimport

import java.io.File


fun main() {
    val tiempoInicio = System.currentTimeMillis()

    //Creamos el csv y estraemos su información
    val csv = File("itinerarios.csv").inputStream()
    val bufferedReader = csv.bufferedReader()
    val lines = bufferedReader.readLines()

    //Guardamos la primera línea en la que estarán los nombres de los elementos
    val entities = lines[0].split(",")

    //Creamos el archivo xml
    val xml_csv = File("xml_csv.xml")

    //Creamos un string donde se irán guardando las líneas del xml para posteriormente escribirlas y añadimos directamente la línea de cabecera y el elemento padre
    var informacion = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<Archivo>\n"

    //Vamos recorriendo las líneas del archivo csv que hemos leido
    for (i in 1..lines.size-1){
        //Añadimos un elemento por cada línea del csv
        informacion += "   <Registro>\n"
        //Hacemos un split para separar por campos de informacion
        var actualLine = lines[i].split(",")
        //Recorremos los campos y añadimos el elemento hijo junto a la información que le corresponde
        for (x in 0..actualLine.size-1){
            informacion += "       <"+entities[x]+">"+actualLine[x]+"</"+entities[x]+">\n"
        }
        //Cerramos el elemento
        informacion += "   </Registro>\n"
    }

    //Cerramos el elemento padre y escribimos en el archivo xml que creamos previamente
    informacion += "</Archivo>"
    xml_csv.writeText(informacion)

    val tiempoFin = System.currentTimeMillis()
    val tiempoTotal = tiempoFin-tiempoInicio
    println("El tiempo es de "+ tiempoTotal + " milisegundos")
}