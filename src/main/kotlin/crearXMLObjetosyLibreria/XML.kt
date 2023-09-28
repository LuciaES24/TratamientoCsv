package crearXMLObjetosyLibreria

class XML {
    //Variable para ir guardando todas las líneas del xml para luego poder escribirlas en un archivo
    var lineas_xml = ""

    //Añade la línea de formato que tienen todos los xml
    fun anadirCabecera(){
        lineas_xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
    }

    //Añade el elemento padre según el nombre que se le pase por parámetros
    fun anadirPadre(elemento : String){
        lineas_xml += "<$elemento>\n"
    }

    //Añade un elemento que tendrá elementos hijo según el nombre que se le pase por parámetros
    fun anadirElemento(elemento: String){
        lineas_xml += "   <$elemento>\n"
    }

    //Añade un elemento hijo según el nombre y la información que se le pase por parámetros
    fun anadirElementoHijoInformacion(elemento:String, info:String){
        lineas_xml += "       <$elemento>$info</$elemento>\n"
    }

    //Cierra el elemento con elementos hijo según el nombre que se le pase por parámetros
    fun cierreElemento(elemento: String){
        lineas_xml += "   </$elemento>\n"
    }

    //Cierra el elemento padre según el nombre que se le pase por parámetros
    fun cierrePadre(elemento: String){
        lineas_xml += "</$elemento>\n"
    }
}