/*
- Atributos: nome, vida, escudo
- Métodos: receberDano, atacar, estaVivo */

public class Inimigo extends Entidade{

    public Inimigo(String nome, int vida, int escudo){
        super(nome, vida, escudo);
    }

    public void atacar(Heroi heroi){
        int dano = 5; 
        heroi.receberDano(dano);
    }
}

//Ideias de nomes de ataques: erro de compilação, esqueceu o ;, deu time limit, caiu num loop infinito