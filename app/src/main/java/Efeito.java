/**
 *Classe elementar que define as estruturas básicas e comuns a todos os tipos de efeitos contidos no jogo.
 */
public abstract class Efeito {
    
    private String nome;
    private String descricao;
    private Entidade dono;
    private int acumulos;

    /**
     * Construtor base para a criação de um efeito.
     * @param nome O nome identificador do efeito.
     * @param descricao Texto explicativo sobre o que o efeito faz.
     * @param dono A entidade que está sob a influência deste efeito.
     * @param acumulos A intensidade inicial/duração em turnos do efeito.
     */
    public Efeito(String nome, String descricao, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
        this.descricao = descricao;
    }

    /**
     * Acessa e retorna o nome, a descrição e a quantidade de acúmulos do efeito.
     * @return Uma String com nome, descrição e acúmulo do efeito.
     */
    public String getString(){
        return nome + descricao + acumulos;
    }

    /**
     * Acessa e retorna o nome do efeito ativo.
     * @return O nome do efeito (String).
     */
    public String getName(){
        return nome;
    }

    /**
     * Acessa e retorna a quem pertence o efeito ativo.
     * @return O dono do efeito (Entidade).
     */
    public Entidade getDono(){
        return dono;
    }

    /**
     * Acessa e retorna a quantidade atual de acúmulo do efeito ativo.
     * @return O acúmulo atual do efeito (int)
     */
    public int getAcumulo(){
        return acumulos;
    }

    /**
     * Permite que o parâmetro "acumulo" do efeito seja modificado a medida que as rodadas acontecem e este aumenta ou diminui.
     * @param newAcumulo O novo acúmulo do efeito ativo.
     */
    public void setAcumulo(int newAcumulo){
        this.acumulos = newAcumulo;
    }

    /**
     * Permite que o dono do efeito seja modificado a medida que as rodadas acontecem.
     * @param newDono O novo dono do efeito ativo.
     */
    public void setDono(Entidade newDono){
        this.dono = newDono;
    }

    /**
     * Versão elementar da função que permite a notificação dos efeitos no jogo, comum a todos os efeitos.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    public abstract void serNotificado(Evento evento, Combate combate); //vai ser subscrito em todos os efeitos que herdarem dessa classe
}
