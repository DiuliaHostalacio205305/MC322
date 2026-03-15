/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano extends Carta{
    
    private int dano;

    public CartaDano(String nome, String descricao, int custo, int dano){
        super(nome, nome, custo);
        this.dano = dano;
    }

    @Override
    public void usar(Tabuleiro tabuleiro){
        tabuleiro.getInimigo().receberDano(dano);
        tabuleiro.getHeroi().gastaEnergia();
    }
    
    public int getDano(){
        return dano;
    }
}

