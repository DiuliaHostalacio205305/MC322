/* 
- Atributos: nome, vida, escudo
- Métodos: receberDano, ganharEscudo, estaVivo */

public class Heroi{

    private String nome;
    private int vida;
    private int escudo;
    private int energia;


    public Heroi(String nome, int vida, int escudo, int energia){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.energia = energia;
    }

    public void receberDano(int dano){
        this.vida = vida - dano;
    }

    public void gastaEnergia(){
        this.energia = energia - 1;
    }

    public void ganharEscudo(int shield){ //muda internamente o valor das variáveis
        this.escudo = escudo + shield;
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
}