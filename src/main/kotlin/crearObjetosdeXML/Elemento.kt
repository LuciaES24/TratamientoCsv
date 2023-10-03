package crearObjetosdeXML

class Elemento(nombre:String, info:String) {
    var nombreElemento = nombre
    var infoElemento = info
    var nombreAtributo = ""
    var infoAtributo = ""

    constructor(nombre: String, info: String, nombreAtt :String, infoAtt:String):this(nombre,info){
        nombreAtributo = nombreAtt
        infoAtributo = infoAtt
    }
}