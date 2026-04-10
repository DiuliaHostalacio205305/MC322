/**
 *Classe elementar que define as estruturas básicas e comuns a todos os tipos de Entidades contidas no jogo.
 */
import java.util.ArrayList;
import java.util.List;

public abstract class Entidade {
    
    private String nome;
    private int vida;
    private int escudo;
    private List<Efeito> efeitosAtivos;
    
    /**
     * Construtor da classe Entidade.
     * @param nome O nome que identifica a entidade no jogo.
     * @param vida A quantidade de pontos de vida da entidade.
     * @param escudo A quantidade de pontos de escudo da entidade.
     */
    public Entidade(String nome, int vida, int escudo){
        this.nome = nome;
        this.vida = vida;
        this.escudo = escudo;
        this.efeitosAtivos = new ArrayList<>();
    }

    /**
     * Versão elementar da função que permite que as Entidades sofram dano no jogo, comum a todas as entidades.
     * @param dano O dano que a entidade está recebendo.
     */
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

    /**
     * Versão elementar da função que permite que as Entidades recebam escudo no jogo, comum a todas as entidades.
     * @param shield O escudo que a entidade está recebendo.
     */
    public void ganharEscudo(int shield){ //muda internamente o valor das variáveis
        if(this.escudo + shield > 3){
            this.escudo = 3;
        } else {
            this.escudo = escudo + shield;
        }
    }

    /**
     * Checa se a entidade está viva, isto é, se sua vida é maior que 0 Hp.
     * @return booleano, true se vivo, false se morto.
     */
    public boolean estaVivo(){
        if (vida <= 0){ 
            return false;
        }
        return true;
    }

    /**
     * Acessa e retorna o nome da entidade.
     * @return O nome da entidade (String)
     */
    public String getName(){
        return this.nome;
    }

    /**
     * Acessa e retorna a vida atual da entidade.
     * @return A vida atual da entidade (int)
     */
    public int getVida(){
        return this.vida;
    }

    /**
     * Acessa e retorna o escudo atual da entidade.
     * @return O escudo da entidade (int)
     */
    public int getEscudo(){
        return escudo;
    }

    /**
     * Permite que o escudo da entidade seja modificado ao longo das rodadas.
     */
    public void resetaEscudo(){
        this.escudo = 0; 
    }

    /**
     * Atribui à entidade o nome escolhido
     * @param nome O novo nome da entidade
     */
    public void setNome(String nome){
        this.nome = nome;
    }

    /**
     * Permite que o novo efeito ativo na entidade seja utilizado, ou seja, inscreve e coloca o efeito na
     * lista de efeitos ativos {@link efeitosAtivos}.
     * @param efeito O efeito que será adicionado e ativado.
     */
    public void usarEfeito(Efeito efeito){ //tem que colocar o caso aqui da entidade já ter o efeito, dai tem que somar os acumulos
        this.efeitosAtivos.add(efeito);
    }

    /**
     * Remove o efeito que acabou da entidade, ou seja, o retira da lista de efeitos ativos {@link efeitosAtivos}.
     * @param efeito O efeito que será retirado e desativado.
     */
    public void excluirEfeito(Efeito efeito){
        this.efeitosAtivos.remove(efeito);
    }

    /**
     * Acessa e retorna o valor do efeito lockin (força) ativo na entidade.
     * @return O valor do efeito lockin (int).
     */
    public int getLockin(){
        int total = 0;
        for(int i = 0; i < this.efeitosAtivos.size(); i++){ //roda a lista de efeitos ativos
            Efeito atual = this.efeitosAtivos.get(i); //seta o efeito que está sendo analizado como o atual
            if(atual instanceof Lockin){ //vê se o atual é realmente um efeito de força (e não veneno por exemplo)
                total += atual.getAcumulo();
            }
        }
        return total;
    }

    /**
     * Acessa e retorna o valor do efeito burnout (veneno) ativo na entidade.
     * @return O valor do efeito burnout (int).
     */
    public int getBurnout(){
        int total = 0;
        for(int i = 0; i < this.efeitosAtivos.size(); i++){
            Efeito atual = this.efeitosAtivos.get(i);
            if(atual instanceof Burnout){
                total += atual.getAcumulo();
            }
        }
        return total;
    }

}
