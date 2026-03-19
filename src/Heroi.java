/* 
- Atributos: nome, vida, escudo
- Métodos: receberDano, ganharEscudo, estaVivo */

public class Heroi extends Entidade{
    
    private int cafeina;
    private int escudoMax;

    public Heroi(String nome, int vida, int escudo, int cafeina, int escudoMax){
        super(nome, vida, escudo);
        this.cafeina = cafeina;
        this.escudoMax = escudoMax;
    }

    public void gastaEnergia(int quantidade){
        this.cafeina = cafeina - quantidade;
    }

    public int getCafeina(){
        return cafeina;
    }
    
    public void setCafeina(int cafeina) {
        this.cafeina = cafeina;
    }

    public int getescudoMax(){
        return escudoMax;
    }
}