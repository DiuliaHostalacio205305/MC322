package ic.entidades;
import java.util.Random;

import ic.lógica.Combate;
import ic.lógica.Tabuleiro;

/**
 *Classe que cria o inimigo do jogo.
 Herda de Entidade {@link Entidade}.
 */

public class Inimigo extends Entidade{
    
    protected int intencao; //o ataque do inimigo vai ficar salvo aqui
    int vidaMax;

    /**
     * Construtor da classe Inimigo, com seus atributos básicos
     * @param nome O nome do inimigo
     * @param vida A vida atual do inimigo
     * @param escudo O escudo atual do inimigo
     * @param vidaMax A vida máxima, e inicial, do inimigo
     */
    public Inimigo(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo);
        this.vidaMax = vidaMax; 
    }

    /**
     * Acessa e retorna a vida máxima que o inimigo pode ter.
     * @return A vida máxima do inimigo (int).
     */
    public int getvidaMax(){
        return vidaMax;
    }

    /**
     * Acessa e retorna o que o inimigo pretende realizar naquele turno (intenção).
     * @return A intenção do inimigo (int).
     */
    public int getIntencao(){
        return intencao;
    }

    /**
     * Sorteia a partir do random {@link Random} a ação do inimigo naquele turno
     */
    public void randomizarAtaque(){
        Random random = new Random();
        this.intencao = random.nextInt(4);
    }

    
    /**
     * Controla o ataque do inimigo durante o turno, a partir da intenção randomizada anteriormente
     * @param heroi O herói do jogo que poderá sofrer uma ação do inimigo 
     * @param combate Classe que controla o fluxo do jogo.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
    */
    public void atacar(Entidade heroi, Combate combate, Tabuleiro tabuleiro){}
   
    /**
     * Permite que cada inimigo tenha uma fala personalizada no começo da rodada 
     * @param heroi O herói do jogo que poderá sofrer uma ação do inimigo
     */
    public void falaRodada1(Heroi heroi){};

    /**
     * Imprime a ação do inimigo calculada pela intenção, que permite avisar ao jogador a intenção do inimigo no começo da rodada
     * @param acao
     */
    public void imprimeAcaoInimigo(int acao){};

    /**
     * Define a intenção do inimigo (útil para testes automatizados).
     * @param intencao O índice da ação (0-3).
     */
    public void setIntencao(int intencao) {
        this.intencao = intencao;
    }

}
