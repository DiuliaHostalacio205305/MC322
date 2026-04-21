package ic.inimigos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;

/**
 * Classe de testes unitários para o inimigo Mc458 
 * Garante que todas as ações (Dano, Burnout, Lock-in e Escudo) 
 * possuam os valores de efeito corretos conforme a implementação da classe.
 */
public class Mc458Test {

    @Test
    public void testarAcoesMc458() {
        Heroi h = new Heroi("Heroi", 50, 0, 3, 3, 50);
        Mc458 inimigo = new Mc458("MC458", 60, 0, 60);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, inimigo, t, s);

        assertDoesNotThrow(() -> {
            inimigo.falaRodada1(h);
            inimigo.imprimeAcaoInimigo(0);
        });

        // Ação 0: 6 de dano
        inimigo.setIntencao(0);
        inimigo.atacar(h, c, t);
        assertEquals(6, 50 - h.getVida(), "O dano da ação 0 do MC458 está incorreto.");

        // Ação 1: 4 acúmulos
        inimigo.setIntencao(1);
        inimigo.atacar(h, c, t);
        assertEquals(4, h.getBurnout(), "O burnout aplicado pelo MC458 está incorreto.");

        // Ação 2: 4 de LockIn
        inimigo.setIntencao(2);
        inimigo.atacar(h, c, t);
        assertEquals(4, inimigo.getLockin(), "O ganho de força (Lock-in) do MC458 está incorreto.");

        // Ação 3: 3 de escudo
        inimigo.setIntencao(3);
        inimigo.atacar(h, c, t);
        assertEquals(3, inimigo.getEscudo(), "O ganho de escudo do MC458 está incorreto.");
    }
}