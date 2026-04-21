package ic.cartas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Testes para a classe Carta
 * Garante que a estrutura básica de qualquer carta funcione corretamente
 */
public class CartaTest {

    @Test
    /**
     * Cria uma carta genérica para teste 
     * e verifica se o que foi passado no construtor deve ser o que o getter retorna
     */
    public void testarAtributosBasicos() {
  
        String nomeTeste = "Nome da Carta";
        String descTeste = "Descrição da Carta";
        int custoTeste = 3;
        
        Carta carta = new Carta(nomeTeste, descTeste, custoTeste);

        assertEquals(nomeTeste, carta.getName(), "O nome da carta não tá igual ao definido no construtor.");
        assertEquals(descTeste, carta.getDescricao(), "A descrição não tá igual à definida no construtor."); 
        assertEquals(custoTeste, carta.getCusto(), "O custo não tá igual ao definido no construtor."); 
    }

    @Test
    /**
     * Apenas testa se não gera nenhuma exceção como chamado, pois o metódo é vazio.
     */
    public void testarMetodoUsarVazio() {
        Carta carta = new Carta("Teste", "Desc", 0);
        assertDoesNotThrow(() -> {
            carta.usar(null, null);
        }, "O método usar da classe base está lançando exceções");
    }
}