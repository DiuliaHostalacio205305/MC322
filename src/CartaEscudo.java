/*
- Atributos: nome, custo
- Métodos: usar */

public class CartaEscudo extends Carta {

    private int escudo;

    public CartaEscudo(String nome, String descricao, int custo, int escudo){
        super(nome, descricao, custo);
        this.escudo = escudo;
    }

    @Override
    public void usar(Tabuleiro tabuleiro){
        System.out.println("\nUsando a carta: " + getName());
        tabuleiro.getHeroi().ganharEscudo(escudo);
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
    }

    public int getEscudo(){
        return escudo;
    }
    
}
