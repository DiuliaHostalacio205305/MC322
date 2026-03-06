/*
- Atributos: nome, custo
- Métodos: usar */

public class CartaEscudo {
    
    private String nome;
    private int custo;
    private int escudo;

    public CartaEscudo(String nome, int custo, int escudo){
        this.nome = nome;
        this.custo = custo;
        this.escudo = escudo;
    }

    public void usar(Heroi heroi){
        heroi.ganharEscudo(escudo);
        heroi.gastaEnergia();
    }

    public String getName(){
        return this.nome;
    }

    public int getCusto(){
        return this.custo;
    }

    public int getEscudo(){
        return escudo;
    }
    
}
