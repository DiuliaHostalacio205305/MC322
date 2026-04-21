package ic.efeito;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import ic.entidades.Heroi; 
import ic.lógica.Combate;
import ic.lógica.Evento;

/**
 * Testes para a classe abstrata Efeito
 * Valida a estrutura básica de armazenamento de nomes, descrições e acúmulos
 */
public class EfeitoTest {

    //Cria uma classe concreta EfeitoeMock apenas para poder testar os métodos de Efeito que é abstrata
    private class EfeitoMock extends Efeito {
        public EfeitoMock(String nome, String descricao, ic.entidades.Entidade dono, int acumulos) {
            super(nome, descricao, dono, acumulos);
        }

        @Override
        public void serNotificado(Evento evento, Combate combate) {
            //Método vazio para satisfazer a classe abstrata
        }
    }

    @Test
    /**
     * Verifica se os dados passados no construtor são retornados corretamente pelos getters
     */
    public void testarAtributosIniciais() {
        Heroi h = new Heroi("Heroi", 10, 0, 3, 5, 10);
        EfeitoMock e = new EfeitoMock("Nome", "Tira vida", h, 5);

        assertEquals("Nome", e.getName(), "O nome do efeito não tá igual ao do construtor.");
        assertEquals(5, e.getAcumulo(), "A quantidade de acúmulos não tá igual ao esperado.");
        assertEquals(h, e.getDono(), "O dono associado ao efeito não tá igual ao definido.");
    }

    @Test
    /**
     * Testa se a função getString está concatenando o nome, descrição e acúmulo corretamente
     */
    public void testarGetString() {
        EfeitoMock e = new EfeitoMock("Nome", "Descriçao", null, 2);
    
        // O seu método faz: nome + descricao + acumulos
        String esperado = "NomeDescriçao2";
        
        assertEquals(esperado, e.getString(), "A String de resumo do efeito não tá igual ao formato esperado.");
    }

    @Test
    /**
     * Garante que os métodos setAcumulo e setDono alteram os valores conforme o esperado
     */
    public void testarSetters() {
        Heroi h1 = new Heroi("H1", 10, 0, 3, 5, 10);
        Heroi h2 = new Heroi("H2", 10, 0, 3, 5, 10);
        EfeitoMock e = new EfeitoMock("Teste", "Desc", h1, 1);

        e.setAcumulo(10);
        e.setDono(h2);

        assertEquals(10, e.getAcumulo(), "O novo valor de acúmulo não tá igual após o set.");
        assertEquals(h2, e.getDono(), "O novo dono não foi alterado corretamente pelo set.");
    }
}