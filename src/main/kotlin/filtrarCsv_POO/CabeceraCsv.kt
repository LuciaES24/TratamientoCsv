package filtrarCsv_POO

class CabeceraCsv(columnas: String) {
    val listaCabecera = columnas.split(",")

    fun buscarInfo(buscar: String): Int {
        var posicion = listaCabecera.indexOf(buscar)
        return posicion
    }
}