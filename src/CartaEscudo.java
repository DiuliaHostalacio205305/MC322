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
        tabuleiro.getHeroi().ganharEscudo(escudo);
    }

    public int getEscudo(){
        return escudo;
    }
    
}
