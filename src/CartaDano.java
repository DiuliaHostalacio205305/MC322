/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano {
    
    private String nome;
    private int custo;

    public CartaDano(String nome, int custo){
        this.nome = nome;
        this.custo = custo;
    }

    public void usar(Inimigo inimigo, Heroi heroi){
        int dano = 3;
        inimigo.receberDano(dano);
        heroi.gastaEnergia();
    }

    public String getName(){
        return this.nome;
    }

    public int getCusto(){
        return this.custo;
    }
    
}
