package ic.cartas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;
import java.util.Scanner;

/**
 * Testes para a classe CartaBurnout
 * Valida se o veneno é aplicado corretamente e se a cafeína do herói é descontada apenas no cenário certo
 */
public class CartaBurnoutTest {

    @Test
    /**
     * Verifica o cenário onde o herói usa a carta contra o inimigo.
     * O inimigo deve receber o veneno e a cafeína do herói deve diminuir.
     */
    public void testarHeroiUsandoNoInimigo() {
        Heroi h = new Heroi("Nome", 50, 0, 3, 10, 50); 
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        
        //Cria um scanner fake, já q o combate precisa dele
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaBurnout carta = new CartaBurnout("Burnout", "Descrição", 1, 5, i);
        carta.usar(t, c);
        assertEquals(2, h.getCafeina(), "A cafeína do herói não tá igual ao esperado após o gasto.");
        assertEquals(5, i.getBurnout(), "O acúmulo de veneno no inimigo tá errado.");
    }

    @Test
    /**
     * Testa o cenário onde o inimigo usa a carta contra o herói.
     * O herói deve receber o veneno, mas sua cafeína deve continuar intacta.
     */
    public void testarInimigoUsandoNoHeroi() {
        Heroi h = new Heroi("Nome", 50, 0, 3, 10, 50);
        Inimigo i = new Inimigo("Inimigo", 20, 0, 20);
        
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, i, t, s);
        CartaBurnout carta = new CartaBurnout("Burnout", "Descrição", 0, 3, h);
        carta.usar(t, c);
        assertEquals(3, h.getCafeina(), "A cafeína do herói mudou, mas o inimigo que usou a carta");
        assertEquals(3, h.getBurnout(), "O valor do veneno no herói não tá igual ao esperado.");
    }
}