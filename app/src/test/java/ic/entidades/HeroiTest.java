package ic.entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Heroi
 * Valida se os atributos iniciais, o gasto de cafeína e os limites de vida/escudo estão corretos
 */
public class HeroiTest {

    @Test
    /**
     * Verifica se o herói é criado com os valores certos passados no construtor
     */
    public void testarAtributosIniciais() {
        Heroi h = new Heroi("Nome", 50, 10, 3, 20, 50);
        assertEquals("Nome", h.getName(), "O nome do herói não tá igual ao que foi definido.");
        assertEquals(50, h.getVida(), "A vida inicial não tá batendo.");
        assertEquals(10, h.getEscudo(), "O escudo inicial tá errado.");
        assertEquals(3, h.getCafeina(), "A cafeína inicial não tá igual.");
        assertEquals(20, h.getescudoMax(), "O valor do escudo máximo tá errado.");
        assertEquals(50, h.getvidaMax(), "A vida máxima não tá igual ao esperado.");
    }

    @Test
    /**
     * Testa se a função de gastar energia diminui a cafeína corretamente
     */
    public void testarGastoDeEnergia() {
        Heroi h = new Heroi("Nome", 50, 0, 5, 20, 50);
        h.gastaEnergia(2);
        assertEquals(3, h.getCafeina(), "A cafeína restante após o gasto não tá igual ao esperado.");
    }

    @Test
    /**
     * Verifica se o setCafeina altera o valor da energia do herói corretamente
     */
    public void testarSetCafeina() {
        Heroi h = new Heroi("Nome", 50, 0, 0, 20, 50);
        h.setCafeina(3);
        assertEquals(3, h.getCafeina(), "O valor da cafeína após o set não tá igual.");
    }

    @Test
    /**
     * Testa o recebimento de dano 
     */
    public void testarDanoNaVida() {
        Heroi h = new Heroi("Alvo", 50, 0, 3, 20, 50);
        h.receberDano(15);
        assertEquals(35, h.getVida(), "A vida do herói após o dano não tá igual ao esperado.");
    }
}