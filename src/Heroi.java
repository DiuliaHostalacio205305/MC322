/* 
- Atributos: nome, vida, escudo
- Métodos: receberDano, ganharEscudo, estaVivo */

public class Heroi{

    private String nome;
    private int vida;
    private int escudo;
    private int cafeina;


    public Heroi(String nome, int vida, int escudo, int energia){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.cafeina = energia;
    }

    public void receberDano(int dano){
        this.vida = vida - dano;
    }

    public void gastaEnergia(){
        this.cafeina = cafeina - 1;
    }

    public void ganharEscudo(int shield){ //muda internamente o valor das variáveis
        this.escudo = escudo + shield;
    }

    public void resetaEscudo(){
        this.escudo = 0; //chamar toda vez que reiniciar a jogada
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
        return escudo;
    }

    public int getCafeina(){
        return cafeina;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}