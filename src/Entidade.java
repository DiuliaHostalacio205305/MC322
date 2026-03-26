import java.util.ArrayList;
import java.util.List;

public abstract class Entidade {
    
    private String nome;
    private int vida;
    private int escudo;
    private List<Efeito> efeitosAtivos;
    
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.efeitosAtivos = new ArrayList<>();
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
        if(this.escudo + shield > 3){
            this.escudo = 3;
        } else {
            this.escudo = escudo + shield;
        }
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

    public void usarEfeito(Efeito efeito){ //tem que colocar o caso aqui da entidade já ter o efeito, dai tem que somar os acumulos
        this.efeitosAtivos.add(efeito);
        //acho que dá pra colocar um print aq falando q o fulano recebeu um efeito novo ou algo assim
    }

    public void excluirEfeito(Efeito efeito){
        this.efeitosAtivos.remove(efeito);
    }

}
