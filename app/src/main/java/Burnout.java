/**
 * Efeito análogo a um veneno, tira vida de Entidades progressivamente. 
 * O dano causado é igual ao valor do acúmulo do efeito na Entidade naquele momento, 
 * ou seja, se o acúmulo na rodada do efeito Burnout é igual a 3, o dano causado será igual a 3.
 * O acúmulo diminui em 1 a cada rodada que passa, até chegar em 0, onde o efeito acaba.
 * Herda da classe Efeito {@link Efeito}
 */
public class Burnout extends Efeito {
    
    /**
     * Construtor da classe Burnout.
     * @param nome O nome identiifcador do efeito
     * @param descricao Texto explicando o que o Burnout causará à entidade.
     * @param dono A Entidade (Heroi ou Inimigo) que está sofrendo o efeito.
     * @param acumulos A intensidade/número de turnos que o efeito durará.
     */
    public Burnout(String nome, String descricao, Entidade dono, int acumulos){
        super(nome, descricao, dono, acumulos);
    }

    /**
     *Notifica o efeito Burnout que a rodada acabou e que é o momento de causar dano, bem como diminuir o acúmulo.
     *Desenscreve o efeito do Publisher, a classe Combate, caso acúmulo = 0. {@link Combate}
     *@param evento Estado atual da rodada que está ocorrendo, início, ataque do herói, dano do herói, fim da rodada.
     *@param combate classe que controla o sistema de notificações (age como Publisher).
     */
    @Override
    public void serNotificado(Evento evento, Combate combate){
        if(evento == Evento.FIM){ 
            int dano = this.getAcumulo(); //no caso, o dano que a entidade sofrerá é o acúmulo da rodada
            getDono().receberDano(dano);
            
            this.setAcumulo(this.getAcumulo() - 1); //seta um novo acumulo retirando 1
            
            if(this.getAcumulo() <= 0){
                System.out.println("O efeito do veneno acabou!");
                this.getDono().excluirEfeito(this);
                combate.unsubscribe(this);
            }
        }
    }
}
