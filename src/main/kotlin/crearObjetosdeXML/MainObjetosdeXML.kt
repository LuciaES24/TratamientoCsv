package crearObjetosdeXML


import java.io.File
import javax.lang.model.element.Element
import javax.xml.parsers.DocumentBuilderFactory


fun main(){
    val xml = File("itinerariosAtributo.xml")
    val dbFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = dbFactory.newDocumentBuilder()
    val doc = dBuilder.parse(xml)

    val nodeList = doc.getElementsByTagName("REGISTRO")
    var listaElementos = mutableListOf<Elemento>()

    for (i in 0..nodeList.length-1){
        var listaHijos = mutableListOf<Elemento>()
        var nodo = nodeList.item(i)
        var elemento = nodo.childNodes

    }


}