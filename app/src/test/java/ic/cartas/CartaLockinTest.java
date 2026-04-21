package ic.cartas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;

/**
 * Testes para a classe CartaLockin
 * Verifica se o bônus de força é aplicado na entidade certa e se a cafeína do herói é descontada
 */
public class CartaLockinTest {

    @Test
    /**
     * Testa o cenário onde o herói usa a carta em si mesmo para aumentar seu dano.
     * Deve gastar cafeína e aumentar o valor de Lock-in do herói.
     */
    public void testarHeroiUsandoEmSi() {
        Heroi h = new Heroi("Heroi", 50, 0, 4, 3, 50);
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaLockin carta = new CartaLockin("Lockin", "Descrição", 2, 2, h);
        carta.usar(t, c);

        assertEquals(2, h.getCafeina(), "A cafeína do herói não tá igual ao esperado após o gasto.");
        assertEquals(2, h.getLockin(), "O acúmulo de Lock-in no herói não tá igual ao valor da carta.");
    }

    @Test
    /**
     * Testa o cenário onde o inimigo ganha força (Lock-in).
     * O inimigo deve receber o bônus e a cafeína do herói não deve ser alterada.
     */
    public void testarInimigoGanhandoForca() {
        Heroi h = new Heroi("Heroi", 50, 0, 4, 3, 50);
        Inimigo i = new Inimigo("Inimigo", 30, 0, 30);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaLockin carta = new CartaLockin("Lockin", "Descrição", 0, 3, i);
        carta.usar(t, c);

        assertEquals(4, h.getCafeina(), "A cafeína do herói mudou, mas quem ganhou força foi o inimigo");
        assertEquals(3, i.getLockin(), "O valor do Lock-in do inimigo não tá igual ao esperado.");
    }
}