public class CartaBurnout extends Carta{

    private int burnout;
    private Entidade alvoEntidade;

    public CartaBurnout(String nome, String descricao, int custo, int burnout, Entidade alvoEntidade){
        super(nome, descricao, custo);
        this.burnout = burnout;
        this.alvoEntidade = alvoEntidade;
    }

    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println("Usando a carta " + getName());
        Burnout novoBurnout = new Burnout(getName(), getDescricao(), alvoEntidade, burnout);
        alvoEntidade.usarEfeito(novoBurnout);
        combate.subscribe(novoBurnout);        
    }
    
}
