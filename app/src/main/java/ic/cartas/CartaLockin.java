package ic.cartas;

import ic.efeito.Lockin;
import ic.entidades.Entidade;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;
import ic.organização.Cores;

/**
 *Classe que cria as cartas associadas ao efeito Lockin (força)) {@link Lockin}.
 Herda de Carta {@link Carta} e permite utilizar o efeito de Lockin em alguma entidade
 */
public class CartaLockin extends Carta{

    private int strenght; 
    private Entidade alvoEntidade;

    /**
     * Construtor da classe CartaLockin.
     * @param nome O nome identificador da carta.
     * @param descricao Texto que descreve o efeito ao jogador.
     * @param custo O custo em cafeína da carta.
     * @param strenght A intensidade (número de acúmulos) do efeito.
     * @param alvoEntidade A entidade que será beneficiada pelo efeito.
     */
    public CartaLockin(String nome, String descricao, int custo, int strenght, Entidade alvoEntidade){
        super(nome, descricao, custo);
        this.strenght = strenght;
        this.alvoEntidade = alvoEntidade;
    }

    /**
     * É uma sobrescrição de usar de Carta que permite utilizar a carta de lockin criada.
     * Causa o efeito na entidade desejada, dependendo de qual delas utilizou a carta e cria o novo efeito Lockin
     para ser inscrito na lista de efeitos ativos.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println(Cores.COLOR_PINK + "Usando a carta '" + getName());
        Entidade alvo;
        if(this.alvoEntidade == combate.getInimigo()){ //o inimigo está usando força em si
            alvo = combate.getInimigo();
        } else { //o herói está usando força em si
            alvo = combate.getHeroi();
            System.out.println(Cores.COLOR_ORANGE + "Você aumentou sua Lock-in em " + strenght + " pontos de Lock-in!\nAgora seus ataques darão mais dano!" + Cores.COLOR_RESET);
            tabuleiro.getHeroi().gastaEnergia(this.getCusto());

        }
        Lockin novaLockin = new Lockin(this.getName(), this.getDescricao(), alvo, strenght); 
        alvo.usarEfeito(novaLockin);
        combate.subscribe(novaLockin); 
    }

}
