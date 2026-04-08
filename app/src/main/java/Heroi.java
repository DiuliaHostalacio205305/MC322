/**
 *Classe que cria o herói do jogo.
 Herda de Entidade {@link Entidade}.
 */
public class Heroi extends Entidade{
    
    private int cafeina;
    private int escudoMax;
    private int vidaMax;

    public Heroi(String nome, int vida, int escudo, int cafeina, int escudoMax, int vidaMax){
        super(nome, vida, escudo);
        this.cafeina = cafeina;
        this.escudoMax = escudoMax;
        this.vidaMax = vidaMax;
    }

    /**
     * Gasta a cafeína (energia) do herói para controlar e limitar suas ações por turno.
     * @param quantidade A quantidade de cafeína que o herói perderá.
     */
    public void gastaEnergia(int quantidade){
        this.cafeina = cafeina - quantidade;
    }

    /**
     * Acessa e retorna a cafeína (energia) atual do herói.
     * @return A energia do herói (int)
     */
    public int getCafeina(){
        return cafeina;
    }
    
    /**
     * Permite modificar o valor da cafeína do herói ao longo das rodadas
     * @param cafeina O novo valor de cafeína do herói.
     */
    public void setCafeina(int cafeina) {
        this.cafeina = cafeina;
    }

    /**
     * Acessa e retorna o escudo máximo que o herói pode ter.
     * @return O escudo máximo do herói (int).
     */
    public int getescudoMax(){
        return escudoMax;
    }

    /**
     * Acessa e retorna a vida máxima que o herói pode ter.
     * @return A vida máxima do herói (int).
     */
    public int getvidaMax(){
        return vidaMax;
    }
}