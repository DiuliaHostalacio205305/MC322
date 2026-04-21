package ic.cartas;

import ic.entidades.Heroi;
import ic.inimigos.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Evento;
import ic.lógica.Tabuleiro;
import ic.organização.Cores;
/**
 *Classe que cria as cartas que causam dano.
 Herda de Carta {@link Carta} e permite causar dano imediato em alguma entidade Inimigo {@link Inimigo}.
 */
public class CartaDano extends Carta{
    
    private int dano;
    
    /**
     * Construtor da classe CartaDano.
     * Inicializa os atributos básicos necessários para a carta Dano do jogo.
     * @param nome O nome identificador da carta.
     * @param descricao O texto que explica o que a carta faz quando usada.
     * @param custo O valor em cafeína necessário para jogar esta carta.
     * @param dano O valor de dano que a carta causará ao ser usada
     */
    public CartaDano(String nome, String descricao, int custo, int dano){
        super(nome, descricao, custo);
        this.dano = dano;
    }

    /**
     * É uma sobrescrição de usar de Carta que permite utilizar a carta de dano criada.
     * Causa o dano em qualquer entidade inimigo {@link Inimigo} e retira cafeína do herói {@link Heroi}.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        //Avisa que o heroi atacou
        combate.notify(Evento.ATAQUE_HEROI);
        System.out.println(Cores.COLOR_ORANGE + "\nUsando a carta: " + getName());
        System.out.println("Você deu " + (getDano() + combate.getHeroi().getLockin()) + " de dano!");
        combate.getInimigo().receberDano(dano + combate.getHeroi().getLockin());
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
        if(combate.getInimigo().getVida() <= 0) {
            System.out.println(Cores.COLOR_RED + "Vida de " + combate.getInimigo().getName() + ": 0/" + combate.getInimigo().getvidaMax() + Cores.COLOR_RESET);

        } 
        else{
            System.out.println(Cores.COLOR_RED + "Vida de " + combate.getInimigo().getName() + ": " + combate.getInimigo().getVida() + "/" + combate.getInimigo().getvidaMax() + Cores.COLOR_RESET);
        }
    }
    
    /**
     * Acessa e retorna o dano causado pela carta
     * @return O dano causado (int)
     */
    public int getDano(){
        return dano;
    }
}
