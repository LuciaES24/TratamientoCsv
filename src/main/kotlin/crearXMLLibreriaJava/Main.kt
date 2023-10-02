package crearXMLLibreriaJava
import org.w3c.dom.Document
import java.io.File
import java.io.FileNotFoundException
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.Transformer
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main(args: Array<String>) {
    try {
        //Creamos el csv y estraemos su información
        val csv = File(args[0]).inputStream()
        val bufferedReader = csv.bufferedReader()
        val lines = bufferedReader.readLines()

        if (lines.isEmpty()){
            throw FileNotFoundException()
        }else {
            val tiempoInicio = System.currentTimeMillis()

            //Guardamos la primera línea en la que estarán los nombres de los elementos
            val entities = lines[0].split(",")

            // Crear un nuevo documento XML
            val xml = crearDocumentoXML()

            // Crear elementos y agregarlos al documento
            val rootElement = xml.createElement("Archivo")
            xml.appendChild(rootElement)

            //Vamos recorriendo las líneas del archivo csv que hemos leido
            for (i in 1..lines.size-1) {
                //Añadimos un elemento por cada línea del csv
                val elementoHijo = xml.createElement("Registro")
                rootElement.appendChild(elementoHijo)
                //Hacemos un split para separar por campos de informacion
                var actualLine = lines[i].split(",")
                //Recorremos los campos y añadimos el elemento hijo junto a la información que le corresponde
                for (x in 0..actualLine.size-1){
                    val elementoHijo2 = xml.createElement(entities[x])
                    elementoHijo2.textContent = actualLine[x]
                    elementoHijo.appendChild(elementoHijo2)
                }
            }

            // Guardar el documento XML en un archivo
            guardarDocumentoXML(xml, "itinerarios.xml")

            val tiempoFin = System.currentTimeMillis()
            val tiempoTotal = tiempoFin-tiempoInicio
            println("El tiempo es de "+ tiempoTotal + " milisegundos")
        }
    }catch (e:FileNotFoundException){
        println("El archivo no se ha encontrado o está vacío")
    }
}
fun crearDocumentoXML(): Document {
    val factory = DocumentBuilderFactory.newInstance()
    val builder = factory.newDocumentBuilder()
    return builder.newDocument()
}

fun guardarDocumentoXML(doc: Document, nombreArchivo: String) {
    val transformerFactory = TransformerFactory.newInstance()
    val transformer: Transformer = transformerFactory.newTransformer()
    transformer.setOutputProperty("indent", "yes") // Habilitar la indentación
    transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2") // Espacios de indentación
    val source = DOMSource(doc)
    val result = StreamResult(File(nombreArchivo))
    transformer.transform(source, result)
    println("Archivo XML guardado como $nombreArchivo")
}