package filtrarCsv_POO

class LineaInformacion(info:String) {
    var informacion = info

    fun compararInfo(posicion: Int,comparar : String) : Boolean{
        val listaInformacion = informacion.split(",")
        var correcta = true
        for (i in 0..listaInformacion.size-1){
            if (i == posicion && listaInformacion[i]==comparar){
                correcta = true
                break
            }else{
                correcta = false
            }
        }
        return correcta
    }

    override fun toString(): String {
        return "'$informacion'"
    }


}