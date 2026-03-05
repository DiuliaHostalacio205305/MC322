/*
- Atributos: nome, custo
- Métodos: usar */

public class CartaEscudo {
    
    private String nome;
    private int custo;

    public CartaEscudo(String nome, int custo){
        this.nome = nome;
        this.custo = custo;
    }

    public void usar(Heroi heroi){
        int shield = 2;
        heroi.ganharEscudo(shield);
        heroi.gastaEnergia();
    }

    public String getName(){
        return this.nome;
    }

    public int getCusto(){
        return this.custo;
    }
    
}
