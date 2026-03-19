/*
- Atributos: nome, custo
- Métodos: usar */

public class CartaEscudo extends Carta {

    private int escudo;
    public static final String colorCyan = "\u001B[36m";
    public static final String colorReset = "\u001B[0m";
    public static final String colorBlue = "\u001B[94m";

    public CartaEscudo(String nome, String descricao, int custo, int escudo){
        super(nome, descricao, custo);
        this.escudo = escudo;
    }

    @Override
    public void usar(Tabuleiro tabuleiro){
        System.out.println(colorCyan + "\nUsando a carta: " + getName());
        System.out.println("Você recebeu " + getEscudo() + " de escudo!");
        tabuleiro.getHeroi().ganharEscudo(escudo);
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
        System.out.println(colorBlue + "Escudo de " + tabuleiro.getHeroi().getName() + ": " + tabuleiro.getHeroi().getEscudo() + "/" + tabuleiro.getHeroi().getescudoMax() + colorReset);
    }

    public int getEscudo(){
        return escudo;
    }
    
}
