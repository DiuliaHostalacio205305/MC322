/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano extends Carta{
    
    private int dano;
    public static final String colorOrange = "\u001B[38;5;208m";
    public static final String colorReset = "\u001B[0m";

    public CartaDano(String nome, String descricao, int custo, int dano){
        super(nome, descricao, custo);
        this.dano = dano;
    }

    @Override
    public void usar(Tabuleiro tabuleiro){
        System.out.println(colorOrange + "\nUsando a carta: " + getName());
        System.out.println("Você deu " + getDano() + " de dano!" + colorReset);
        tabuleiro.getInimigo().receberDano(dano);
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
    }
    
    public int getDano(){
        return dano;
    }
}

