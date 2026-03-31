/*
- Atributos: nome, custo
- Métodos: usar*/

public class CartaDano extends Carta{
    
    private int dano;
    public static final String colorOrange = "\u001B[38;5;208m";
    public static final String colorReset = "\u001B[0m";
    public static final String colorRed = "\u001B[31m";

    public CartaDano(String nome, String descricao, int custo, int dano){
        super(nome, descricao, custo);
        this.dano = dano;
    }

    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        //Avisa que o heroi atacou
        combate.notify(Evento.ATAQUE_HEROI);
        System.out.println(colorOrange + "\nUsando a carta: " + getName());
        System.out.println("Você deu " + (getDano() + combate.getHeroi().getLockin()) + " de dano!");
        tabuleiro.getInimigo().receberDano(dano + combate.getHeroi().getLockin());
        tabuleiro.getHeroi().gastaEnergia(this.getCusto());
        if(tabuleiro.getInimigo().getVida() <= 0) {
            System.out.println(colorRed + "Vida de " + tabuleiro.getInimigo().getName() + ": 0/" + tabuleiro.getInimigo().getvidaMax() + colorReset);

        } 
        else{
            System.out.println(colorRed + "Vida de " + tabuleiro.getInimigo().getName() + ": " + tabuleiro.getInimigo().getVida() + "/" + tabuleiro.getInimigo().getvidaMax() + colorReset);
        }
    }
    
    public int getDano(){
        return dano;
    }
}

