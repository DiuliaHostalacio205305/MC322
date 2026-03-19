/*
- Atributos: nome, vida, escudo
- Métodos: receberDano, atacar, estaVivo */

public class Inimigo extends Entidade{

    int vidaMax;

    public Inimigo(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo);
        this.vidaMax = vidaMax; 
    }

    public void atacar(Heroi heroi){
        int dano = 5; 
        heroi.receberDano(dano);
    }

    public int getvidaMax(){
        return vidaMax;
    }
}

//Ideias de nomes de ataques: erro de compilação, esqueceu o ;, deu time limit, caiu num loop infinito