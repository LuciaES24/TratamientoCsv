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
        var nodo = nodeList.item(i).childNodes
        for (x in 0..nodo.length-1){
            var nombreElemento = nodo.item(x).nodeName
            var infoElemento = nodo.item(x).textContent
            if (nodeList.item(x).hasAttributes()){
                var atributo = nodeList.item(x).attributes.item(0).toString().split("=")
                var nombreAtributo = atributo[0]
                var infoAtributo = atributo[1]
                var elemento = Elemento(nombreElemento,infoElemento,nombreAtributo,infoAtributo)
                listaElementos.add(elemento)
            }else{
                var elemento = Elemento(nombreElemento,infoElemento)
                listaElementos.add(elemento)
            }
        }
    }

    for (elemento in listaElementos){
        println(elemento.imprimirElemento())
    }
}
