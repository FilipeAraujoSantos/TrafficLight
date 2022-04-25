package br.com.c6.prova.entity

enum class Farol(val valor: String, val delay: Long) {

    VERMELHO("Vermelho", 1000),
    AMARELO("Amarelo", 1000),
    VERDE("Verde", 4000);

}