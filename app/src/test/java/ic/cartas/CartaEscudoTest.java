package ic.cartas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;

/**
 * Testes para a classe CartaEscudo
 * Verifica se o ganho de escudo funciona, se respeita o limite máximo de 3 
 * e se a cafeína é gasta corretamente
 */
public class CartaEscudoTest {

    @Test
    /**
     * Testa se o herói ganha a quantidade exata de escudo e se gasta a energia certa
     */
    public void testarGanhoDeEscudoSimples() {
        Heroi h = new Heroi("Heroi", 50, 0, 3, 3, 50);
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaEscudo carta = new CartaEscudo("Escudo", "Descrição", 1, 2);
        carta.usar(t, c);

        assertEquals(2, h.getEscudo(), "O escudo do herói não tá igual ao que a carta deveria dar.");
        assertEquals(2, h.getCafeina(), "A cafeína não foi subtraida corretamente após usar o escudo.");
    }

    @Test
    /**
     * Verifica se tá limitando o escudo em 3, mesmo que a carta tente dar mais
     */
    public void testarLimiteDeEscudo() {
        Heroi h = new Heroi("heroi", 50, 2, 3, 3, 50);
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaEscudo carta = new CartaEscudo("Escudo", "Descrição", 1, 2);
        carta.usar(t, c);
        assertEquals(3, h.getEscudo(), "O escudo passou do limite de 3");
    }

    @Test
    /**
     * Testa o get do valor de escudo da carta
     */
    public void testarGetEscudo() {
        CartaEscudo carta = new CartaEscudo("Escudo", "Descrição", 1, 5);
        assertEquals(5, carta.getEscudo(), "O get do escudo não tá retornando o valor definido no construtor da carta");
    }
}