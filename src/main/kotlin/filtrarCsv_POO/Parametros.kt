package filtrarCsv_POO

import java.io.File

class Parametros(args : Array<String>) {
    val csv = File(args[0])

    val buscar = args[1].split("=")
    var recurso = buscar[0]
    var infoFiltrar = buscar[1]

    fun obtenerArchivo():File{
        return csv
    }

    fun obtenerRecurso() : String{
        return recurso
    }

    fun obtenerInfoFiltrar() : String{
        return infoFiltrar
    }
}