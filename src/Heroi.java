/* 
- Atributos: nome, vida, escudo
- Métodos: receberDano, ganharEscudo, estaVivo */

public class Heroi extends Entidade{
    
    private int cafeina;

    public Heroi(String nome, int vida, int escudo, int cafeina){
        super(nome, vida, escudo);
        this.cafeina = cafeina;
    }

    public void gastaEnergia(){
        this.cafeina = cafeina - 1;
    }

    public int getCafeina(){
        return cafeina;
    }
    
    public void setCafeina(int cafeina) {
        this.cafeina = cafeina;
    }
}