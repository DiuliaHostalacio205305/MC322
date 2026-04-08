/**
 *Classe que cria as cartas associadas ao efeito Lockin (força)) {@link Lockin}.
 Herda de Carta {@link Carta} e permite utilizar o efeito de Lockin em alguma entidade
 */
public class CartaLockin extends Carta{

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";
    
    private int strenght; 
    private Entidade alvoEntidade;

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
        System.out.println(COLOR_PINK + "Usando a carta '" + getName());
        Entidade alvo;
        if(this.alvoEntidade == combate.getInimigo()){ //o inimigo está usando força em si
            alvo = combate.getInimigo();
        } else { //o herói está usando força em si
            alvo = combate.getHeroi();
            System.out.println(COLOR_ORANGE + "Você aumentou sua Lock-in em " + strenght + " pontos de Lock-in!\nAgora seus ataques darão mais dano!" + COLOR_RESET);
            tabuleiro.getHeroi().gastaEnergia(this.getCusto());

        }
        Lockin novaLockin = new Lockin(this.getName(), this.getDescricao(), alvo, strenght); 
        alvo.usarEfeito(novaLockin);
        combate.subscribe(novaLockin); //inscreve a Lock-in para ser notificada
    }

}
