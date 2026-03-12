/*
- Atributos: nome, vida, escudo
- Métodos: receberDano, atacar, estaVivo */

public class Inimigo{

    private String nome;
    private int vida;
    private int escudo;


    public Inimigo(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    public void receberDano(int dano){ //muda internamente o valor das variáveis
        this.vida = vida - dano;
    }

    public void ganharEscudo(int shield){ //muda internamente o valor das variáveis
        this.escudo = escudo + shield;
    }

    public void atacar(Heroi heroi){
        int dano = 5; 
        heroi.receberDano(dano);
    }

    public boolean estaVivo(){
        if (vida <= 0){ //se ele morreu, retorna falso
            return false;
        }
        return true;
    }

    public String getName(){
        return this.nome;
    }

    public int getVida(){
        return this.vida;
    }

    public int getEscudo(){
        return this.escudo;
    }
}

//Ideias de nomes de ataques: erro de compilação, esqueceu o ;, deu time limit, caiu num loop infinito