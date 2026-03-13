public class Entidade {
    
    private String nome;
    private int vida;
    private int escudo;
    
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
    }

    public void receberDano(int dano){
        int danoRestante = dano;
        if(escudo - dano <= 0){ //se der mais dano que o escudo do personagem
            danoRestante = -1*(escudo - dano);
            escudo = 0;
            vida = vida - danoRestante; //zera o escudo e subtrai o restante da vida
        }
        else {
            escudo = escudo - dano; //se o escudo for maior que o dano, só tira o escudo
        }
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

    public int getEscudo(){
        return escudo;
    }

    public void resetaEscudo(){
        this.escudo = 0; //chamar toda vez que reiniciar a jogada
    }

    public void setNome(String nome){
        this.nome = nome;
    }

}
