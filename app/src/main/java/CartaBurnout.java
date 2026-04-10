/**
 *Classe que cria as cartas associadas ao efeito Burnout (veneno) {@link Burnout}.
 Herda de Carta {@link Carta} e permite utilizar o efeito de Burnout em alguma entidade
 */
public class CartaBurnout extends Carta{

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";

    private int burnout;
    private Entidade alvoEntidade;

    /**
     * Construtor da classe CartaBurnout.
     * @param nome O nome identificador da carta
     * @param descricao Texto explicativo do efeito da carta.
     * @param custo O custo em cafeína para utilizar a carta.
     * @param burnout A intensidade (número de acúmulos) do efeito de Burnout.
     * @param alvoEntidade A entidade que sofrerá a aplicação do efeito.
     */
    public CartaBurnout(String nome, String descricao, int custo, int burnout, Entidade alvoEntidade){
        super(nome, descricao, custo);
        this.burnout = burnout;
        this.alvoEntidade = alvoEntidade;
    }

    /**
     * É uma sobrescrição de usar de Carta que permite utilizar a carta de burnout criada.
     * Causa o efeito na entidade desejada, dependendo de qual delas utilizou a carta e cria o novo efeito Burnout
     para ser inscrito na lista de efeitos ativos.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println(COLOR_PINK + "Usando a carta '" + getName());
        Entidade alvo;
        if(this.alvoEntidade == combate.getHeroi()){ //significa que o alvo da carta é o herói, o inimigo está atacando
            alvo = combate.getHeroi();
        } else { //o herói está usando a carta
            alvo = combate.getInimigo();
            tabuleiro.getHeroi().gastaEnergia(this.getCusto());
            System.out.println("Você usou uma carta de Veneno contra seu inimigo e agora ele está envenenado!" + COLOR_RESET);
        }
        Burnout novoBurnout = new Burnout(this.getName(), this.getDescricao(), alvo, burnout);
        alvo.usarEfeito(novoBurnout);
        combate.subscribe(novoBurnout);        
    }
}
