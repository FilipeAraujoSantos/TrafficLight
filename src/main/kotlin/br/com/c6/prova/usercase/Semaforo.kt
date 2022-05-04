package br.com.c6.prova.usercase

import br.com.c6.prova.entity.Farol
import java.util.*
import kotlin.concurrent.schedule

/**

----------------------- TESTE DO FAROL --------------------------

Este teste, consiste na programação de um cruzamento viário em que há dois faróis para organizar o fluxo de automóveis.

Considere para o case, que o farol possuí as três cores tradicionais: verde, amarelo e vermelho.

Imagine que o tráfego deve ser organizado de tal forma que enquanto na Rua A, o fluxo está interrompido (vermelho) o
fluxo da Rua B, está liberado (verde).

Considere que haverá um intervalo de tempo em que ocorrerá a alteração deste fluxo, sendo:
 * A Rua A, passará a ter seu fluxo aberto (verde)
 * A Rua B, passará pelo momento de atenção (amarelo) e na sequência, tendo seu fluxo contido (vermelho)

Na sequência, as mudanças de fases e liberação de fluxo para ambas as ruas, devem ocorrer de forma contínua e sem que
haja risco para o tráfego.

 */
class Semaforo(var farolRuaA: Farol, var farolRuaB: Farol) {

    fun iniciarFarol(farolAberto: Farol, farolFechado: Farol, rua: String){
        Timer().schedule(farolAberto.delay){
            var farol = alterarFarol(farolAberto, rua)
            if(farol == Farol.VERMELHO)
                iniciarFarol(farolFechado, farol, alterarRuaAberta(rua))
            else
                iniciarFarol(farol,farolFechado,rua)
        }
    }

    private fun alterarFarol(farolAberto: Farol, rua: String): Farol {
        var farol = when (farolAberto.valor.toUpperCase()) {
            "VERMELHO" -> Farol.VERDE
            "AMARELO" -> Farol.VERMELHO
            "VERDE" -> Farol.AMARELO
            else -> throw Exception("Não conseguimos identificar o valor do farol")
        }
        println("O semaforo da rua ${rua} alterou o farol de: ${farolAberto.valor} para ${farol.valor}.")
        return farol
    }

    private fun alterarRuaAberta(rua: String): String {
        return if (rua == "A") "B" else "A"
    }

}