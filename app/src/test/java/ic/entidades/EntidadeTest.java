package ic.entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ic.efeito.Lockin;

/**
 * Testes para a classe abstrata Entidade
 */
public class EntidadeTest {

    //Cria uma classe concreta EntidadeMock apenas para poder testar os métodos da Entidade que é abstrata
    private class EntidadeMock extends Entidade {
        public EntidadeMock(String nome, int vida, int escudo) {
            super(nome, vida, escudo);
        }
    }

    @Test
    /**
     * Verifica se o dano é subtraído corretamente do escudo antes de atingir a vida
     */
    public void testarReceberDanoComEscudo() {
        Entidade e = new EntidadeMock("Teste", 10, 5);
        e.receberDano(3);
        assertEquals(2, e.getEscudo(), "O escudo não tá igual ao esperado após levar dano parcial.");
        assertEquals(10, e.getVida(), "A vida não deveria ter mudado enquanto tinha escudo.");
    }

    @Test
    /**
     * Testa o cenário onde o dano é maior que o escudo e deve reduzir a vida
     */
    public void testarDanoExcedendoEscudo() {
        Entidade e = new EntidadeMock("Teste", 10, 5);
        e.receberDano(8); // Tira 5 do escudo e 3 da vida
        assertEquals(0, e.getEscudo(), "O escudo deveria ter zerado.");
        assertEquals(7, e.getVida(), "A vida restante após o estouro do escudo não tá igual.");
    }

    @Test
    /**
     * Garante que o escudo não ultrapassa o limite de 3
     */
    public void testarLimiteDeEscudo() {
        Entidade e = new EntidadeMock("Teste", 10, 0);
        e.ganharEscudo(5);
        assertEquals(3, e.getEscudo(), "O escudo tá maior que 3, o limite não foi respeitado.");
    }

    @Test
    /**
     * Verifica se o método estaVivo retorna o booleano correto para diferentes valores de HP
     */
    public void testarEstaVivo() {
        Entidade e = new EntidadeMock("Teste", 10, 0);
        assertTrue(e.estaVivo(), "A entidade deveria estar viva com 10 de HP.");
        e.receberDano(10);
        assertFalse(e.estaVivo(), "A entidade ainda tá viva mesmo com 0 de HP.");
    }

    @Test
    /**
     * Testa a limpeza completa da lista de efeitos ativos
     */
    public void testarLimpaEfeitos() {
        Entidade e = new EntidadeMock("Teste", 10, 0);
        
        //Simula a adição de um efeito
        e.usarEfeito(new Lockin("Efeito", "Dano +1", e, 1));
        e.limpaEfeitos();
        assertEquals(0, e.getLockin(), "A lista de efeitos não tá vazia após o limpaEfeitos.");
    }
}