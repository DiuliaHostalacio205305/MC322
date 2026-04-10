/**
 *Classe que cria as cartas que dão escudo.
 Herda de Carta {@link Carta} e permite aumentar o escudo de uma entidade Heroi {@link Heroi}.
 */
public class CartaEscudo extends Carta {

    private int escudo;
    public static final String colorCyan = "\u001B[36m";
    public static final String colorReset = "\u001B[0m";
    public static final String colorBlue = "\u001B[94m";

    /**
     * Construtor da classe CartaEscudo.
     * @param nome O nome identificador da carta.
     * @param descricao Texto que descreve o escudo para o jogador.
     * @param custo O custo em cafeína necessário para utilizar o escudo.
     * @param escudo A quantidade de pontos de escudo que a carta fornece, com o limite de 3 por rodada.
     */
    public CartaEscudo(String nome, String descricao, int custo, int escudo){
        super(nome, descricao, custo);
        this.escudo = escudo;
    }

    /**
     * É uma sobrescrição de usar de Carta que permite utilizar a carta de escudo criada.
     * Aumenta o escudo em qualquer entidade herói e retira cafeína do mesmo {@link Heroi}.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println(colorCyan + "\nUsando a carta: " + getName());
        System.out.println("Você recebeu " + getEscudo() + " de escudo!");
        tabuleiro.getHeroi().ganharEscudo(escudo);
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
        System.out.println(colorBlue + "Escudo de " + tabuleiro.getHeroi().getName() + ": " + tabuleiro.getHeroi().getEscudo() + "/" + tabuleiro.getHeroi().getescudoMax() + colorReset);
    }

    /**
     * Acessa e retorna o escudo que a carta dá.
     * @return O escudo fornecido pela carta (int).
     */
    public int getEscudo(){
        return escudo;
    }
    
}
