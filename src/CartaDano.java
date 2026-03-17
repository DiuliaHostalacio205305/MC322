/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano extends Carta{
    
    private int dano;

    public CartaDano(String nome, String descricao, int custo, int dano){
        super(nome, descricao, custo);
        this.dano = dano;
    }

    @Override
    public void usar(Tabuleiro tabuleiro){
        System.out.println("\nUsando a carta: " + getName());
        tabuleiro.getInimigo().receberDano(dano);
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
    }
    
    public int getDano(){
        return dano;
    }
}

