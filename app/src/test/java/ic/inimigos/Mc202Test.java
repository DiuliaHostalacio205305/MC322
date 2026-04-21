package ic.inimigos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;

/**
 * Classe de testes unitários para o inimigo Mc202.
* Garante que todas as ações (Dano, Burnout, Lock-in e Escudo) 
 * possuam os valores de efeito corretos conforme a implementação da classe.
 */
public class Mc202Test {

    @Test
    public void testarAcoesMc202() {
        Heroi h = new Heroi("Heroi", 50, 0, 3, 3, 50);
        Mc202 inimigo = new Mc202("MC202", 40, 0, 40);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, inimigo, t, s);

        assertDoesNotThrow(() -> {
            inimigo.falaRodada1(h);
            inimigo.imprimeAcaoInimigo(0);
        });

        // Ação 0: 7 de dano
        inimigo.setIntencao(0);
        inimigo.atacar(h, c, t);
        assertEquals(7, 50 - h.getVida(), "Dano da ação 0 do MC202 está errado.");

        // Ação 1: 6 de burnout
        inimigo.setIntencao(1);
        inimigo.atacar(h, c, t);
        assertEquals(6, h.getBurnout(), "Burnout da ação 1 do MC202 está errado.");

        // Ação 2: 4 de LockIn
        inimigo.setIntencao(2);
        inimigo.atacar(h, c, t);
        assertEquals(4, inimigo.getLockin(), "Força da ação 2 do MC202 está errada.");

        // Ação 3: 3 de escudo
        inimigo.setIntencao(3);
        inimigo.atacar(h, c, t);
        assertEquals(3, inimigo.getEscudo(), "Escudo da ação 3 do MC202 está errado.");
    }
}