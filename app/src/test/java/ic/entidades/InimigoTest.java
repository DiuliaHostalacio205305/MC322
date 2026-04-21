package ic.entidades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Inimigo
 * Verifica os atributos de vida, a lógica de sorteio de ataques e se os métodos base funcionam
 */
public class InimigoTest {

    @Test
    /**
     * Verifica se os dados do inimigo (nome e vida máxima) estão sendo salvos corretamente
     */
    public void testarAtributosIniciais() {
        Inimigo i = new Inimigo("Nome", 30, 0, 30);
        assertEquals("Nome", i.getName(), "O nome do inimigo não tá igual ao do construtor.");
        assertEquals(30, i.getvidaMax(), "A vida máxima do inimigo tá errada.");
    }

    @Test
    /**
     * Garante que a intenção sorteada pelo Random esteja sempre no intervalo entre 0 e 3
     */
    public void testarRandomizarAtaque() {
        Inimigo i = new Inimigo("Sorteador", 20, 0, 20);
        
        //Testa 10 vezes o Ramdom
        for(int j = 0; j < 10; j++) {
            i.randomizarAtaque();
            int acao = i.getIntencao();
            assertTrue(acao >= 0 && acao < 4, "A intenção sorteada (" + acao + ") tá fora do limite permitido.");
        }
    }


    @Test
    /**
     * Testa o recebimento de dano herdado da Entidade para ver se a vida do inimigo baixa
     */
    public void testarDanoInimigo() {
        Inimigo i = new Inimigo("Nome", 20, 5, 20);
        i.receberDano(10); // 5 vai no escudo e 5 na vida
        assertEquals(15, i.getVida(), "A vida do inimigo após levar dano com escudo não tá batendo.");
        assertEquals(0, i.getEscudo(), "O escudo do inimigo deveria ter zerado.");
    }
}