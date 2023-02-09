package com.example.ej11objeto

class Objetos() {
    private var peso = 5
    private var valor = 10
    private var vida = 20

    fun getPeso(): Int {
        return peso
    }
}

class Mochila(var pesoMochila: Int) {
    fun addObjeto(objeto: Objetos) : String {
        if (objeto.getPeso() <= pesoMochila) {
            this.pesoMochila -= objeto.getPeso()
        } else {
            return "La mochila está llena, debes vender artículos"
        }
        return "Peso restante de la Mochila: $pesoMochila"
    }
}