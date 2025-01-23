fun main (){
    val reproductorMidi=ReproductorMidi("pugnodollari.mid")
    println("Cargando juego...")
    Thread.sleep(20000)
    println("Este es el juego del ahorcado")
    println("Tienes 7 intentos para adivinar la palabra")
    println("Escribe ,me rindo, para terminar el juego")
    println("Para ganar tienes que escrbir la palabra concreta, empieza escribiendo UNA letra.")
    println("Despues se escribira la palbara cubierta de asteriscos menos la letra adivinada, ")
    val maxfallos=7
    var acierto=true
    //preparar la correcta
    val frutas= listOf("manzana", "platano", "pera", "cereza")

    var mostrar= mutableListOf<String>()
    val corecta=frutas.random()
    for (i in 1.. corecta.split("").size-1){

        mostrar.add("*")
    }

    //contador de aciertos para gnar el juego
    var aciertos=0
    //comprobar
    var respuesta= readln()

    // numero de fallos para saber que hay que dibujar
    var nfallos=1

    while (nfallos<=maxfallos){
        if (respuesta=="me rindo"){break}
        aciertos=0

        if (respuesta.length==1){
            // comprobar letra
            for (i in 0..corecta.split("").size-1)
                if (respuesta==corecta.split("")[i]){
                    mostrar[i]=corecta.split("")[i]
                    aciertos++ }
        }else{
            //comprobar palabra
            if (respuesta==corecta){
                println("Enorabuena as ganado!!")
                break
            }
        }

        if (aciertos==0){
            println("Has fallado")
            nfallos++
        }
        DibujoAhorcado.dibujar(nfallos)
        println("La palabra a adivinar es ${mostrar.toString()}")
        respuesta= readln().lowercase()
    }
reproductorMidi.cerrar()
}