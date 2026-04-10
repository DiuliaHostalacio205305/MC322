/**
 *Classe elementar que define as estruturas básicas e comuns a todos os tipos de cartas contidas no jogo.
 */
public class Carta {
    
    private String nome;
    private String descricao;
    private int custo;

    /**
     * Construtor da classe Carta.
     * Inicializa os atributos básicos necessários para qualquer carta do jogo.
     * @param nome O nome identificador da carta.
     * @param descricao O texto que explica o que a carta faz quando usada.
     * @param custo O valor em cafeína necessário para jogar esta carta.
     */
    public Carta(String nome, String descricao, int custo){
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }
    /**
     * Versão elementar da função que permite a utilização das cartas do jogo, comum a todas as cartas.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    public void usar(Tabuleiro tabuleiro, Combate combate){}

    /**
     * Acessa e retorna o nome da carta.
     * @return O nome da carta (String).
     */
    public String getName(){
        return nome;
    }

    /**
     * Acessa e retorna a descrição da carta.
     * @return A descrição da carta (String).
     */
    public String getDescricao(){
        return descricao;
    }

    /**
     * Acessa e retorna o custo em cafeína da carta para o jogador.
     * @return O custo (cafeína) da carta (int).
     */
    public int getCusto(){
        return custo;
    }

}
