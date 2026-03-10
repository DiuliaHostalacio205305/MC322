/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano {
    
    private String nome;
    private int custo;
    private int dano;

    public CartaDano(String nome, int custo, int dano){
        this.nome = nome;
        this.custo = custo;
        this.dano = dano;
    }

    public void usar(Inimigo inimigo, Heroi heroi){
        inimigo.receberDano(dano);
        heroi.gastaEnergia();
    }

    public String getName(){
        return this.nome;
    }

    public int getCusto(){
        return this.custo;
    }
    
    public int getDano(){
        return dano;
    }
}

