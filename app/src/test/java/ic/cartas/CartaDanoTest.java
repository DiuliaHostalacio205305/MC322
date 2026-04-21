package ic.cartas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;
import ic.efeito.Lockin;

/**
 * Testes para a classe CartaDano
 * Garante que o dano seja aplicado corretamente (com e sem bônus de força) 
 * e que a cafeína seja descontada
 */
public class CartaDanoTest {

    @Test
    /**
     * Verifica se a carta causa o dano base correto no inimigo 
     * e se gasta a cafeína do herói
     */
    public void testarAtaqueBasico() {
        Heroi h = new Heroi("heroi", 50, 0, 3, 10, 50);
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaDano carta = new CartaDano("Dano", "Descrição", 1, 5);
        carta.usar(t, c);

        assertEquals(15, i.getVida(), "A vida do inimigo não tá igual ao esperado após o dano");
        assertEquals(2, h.getCafeina(), "A cafeína do herói não tá sendo subtraida corretamente.");
    }

    @Test
    /**
     * Testa se o dano da carta é somado corretamente ao efeito Lockin (força) do herói
     */
    public void testarDanoComLockin() {
        Heroi h = new Heroi("Heroi", 50, 0, 3, 10, 50);
        Inimigo i = new Inimigo("inimigo", 30, 0, 30);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);

        Lockin forca = new Lockin("Lockin", "Descrição", h, 3);
        h.usarEfeito(forca);
        CartaDano carta = new CartaDano("Carta Dano", "Descrição", 2, 10);
        carta.usar(t, c);
        assertEquals(17, i.getVida(), "O dano com Lockin não tá dando certo");
    }

    @Test
    /**
     * Apenas verifica se o getter do dano retorna o valor definido no construtor
     */
    public void testarGetDano() {
        CartaDano carta = new CartaDano("Dano", "Desc", 1, 10);
        assertEquals(10, carta.getDano(), "O get de dano não tá retornando o valor definido na carta");
    }
}
