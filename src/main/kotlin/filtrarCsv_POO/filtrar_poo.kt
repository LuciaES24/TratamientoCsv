package filtrarCsv_POO

fun main(args: Array<String>){
    try {
        if (args.size>2){
            throw ArrayIndexOutOfBoundsException()
        }else if(args.isEmpty()){
            throw IllegalArgumentException()
        }else {
            val tiempoInicio = System.currentTimeMillis()

            //Creamos un objeto parámetro del que sacaremos el nombre del csv, el recurso y la información a filtrar
            val parametros = Parametros(args)
            val csv = parametros.obtenerArchivo()
            val recurso = parametros.obtenerRecurso()
            val infoFiltrar = parametros.obtenerInfoFiltrar()

            //Exxtraemos la información del archivo
            val bufferedReader = csv.bufferedReader()
            val lines = bufferedReader.readLines()

            //Creamos la linea de cabecera donde se guardarán los campos del csv
            val cabecera = CabeceraCsv(lines[0])

            //Buscamos la posición que tiene el recurso en la línea de la cabecera
            val posicion = cabecera.buscarInfo(recurso)

            //Creamos una lista donde se guardarán las líneas que coincidan con la búsqueda
            var listaCoincidencias = mutableListOf<LineaInformacion>()

            for (i in 1..lines.size-1){
                //Convertimos cada línea del csv en un objeto LineaInformacion
                var lineaActual = LineaInformacion(lines[i])
                //Comprobamos si la información comparada coincide y la añadimos a la lista
                var coincideInfo = lineaActual.compararInfo(posicion,infoFiltrar)
                if (coincideInfo == true){
                    listaCoincidencias.add(lineaActual)
                }
            }

            //Recorremos la lista y vemos si se han encontrado coincidencias
            if (listaCoincidencias.isEmpty()){
                println("No se han encontrado coincidencias")
            }else{
                for (line in listaCoincidencias){
                    println(line.toString())
                }
            }

            val tiempoFin = System.currentTimeMillis()
            val tiempoTotal = tiempoFin-tiempoInicio
            println("El tiempo es de "+ tiempoTotal + " milisegundos")
        }
    }catch (e: IllegalArgumentException){
        println("No se han dado argumentos")
    }catch (e: ArrayIndexOutOfBoundsException){
        println("Argumentos inválidos")
    }
}