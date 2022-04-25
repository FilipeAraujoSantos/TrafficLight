package br.com.c6.prova

import br.com.c6.prova.entity.Farol
import br.com.c6.prova.usercase.Semaforo

fun main() {
    val semaforo = Semaforo(Farol.VERMELHO, Farol.VERDE)
    println("Iniciando os semaforos. Rua A com sinal: ${semaforo.farolRuaA.valor} e Rua B com sinal: ${semaforo.farolRuaB.valor}")
    semaforo.iniciarFarol(semaforo.farolRuaB, semaforo.farolRuaA,"B")
}
