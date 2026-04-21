package ic.inimigos;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import ic.entidades.Heroi;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;


/**
 * Classe de testes unitários para o inimigo Mc102.
 * Garante que todas as ações (Dano, Burnout, Lock-in e Escudo) 
 * possuam os valores de efeito corretos conforme a implementação da classe.
 */
public class Mc102Test {

    @Test
    public void testarAcoesMc102() {
        Heroi h = new Heroi("Heroi", 50, 0, 3, 3, 50);
        Mc102 inimigo = new Mc102("MC102", 30, 0, 30);
        Scanner s = new Scanner("0\n");
        Tabuleiro t = new Tabuleiro(h);
        Combate c = new Combate(h, inimigo, t, s);

        assertDoesNotThrow(() -> {
            inimigo.falaRodada1(h);
            inimigo.imprimeAcaoInimigo(0);
        });

        // Ação 0: 5 de dano
        inimigo.setIntencao(0);
        inimigo.atacar(h, c, t);
        assertEquals(5, 50 - h.getVida(), "Dano da ação 0 do MC102 está errado.");

        // Ação 1: 4 de burnout
        inimigo.setIntencao(1);
        inimigo.atacar(h, c, t);
        assertEquals(4, h.getBurnout(), "Burnout da ação 1 do MC102 está errado.");

        // Ação 2: 3 de LockIn
        inimigo.setIntencao(2);
        inimigo.atacar(h, c, t);
        assertEquals(3, inimigo.getLockin(), "Força da ação 2 do MC102 está errada.");

        // Ação 3: 3 de escudo
        inimigo.setIntencao(3);
        inimigo.atacar(h, c, t);
        assertEquals(3, inimigo.getEscudo(), "Escudo da ação 3 do MC102 está errado.");
    }
}