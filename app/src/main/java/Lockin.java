/**
 * Efeito análogo a força, aumenta o valor do dano causado por Entidades enquanto o efeito durar. 
 * O dano extra causado é igual ao valor do primeiro acúmulo do efeito, ou seja, 
 * se o acúmulo original do efeito Lockin é igual a 3, o dano extra causado será igual a 3 enquanto o efeito durar.
 * O acúmulo diminui em 1 a cada rodada que passa, até chegar em 0, onde o efeito acaba.
 * Herda da classe Efeito {@link Efeito}
 */
public class Lockin extends Efeito{

    public Lockin(String nome, String descricao, Entidade dono, int acumulos){
        super(nome, descricao, dono, acumulos);
    }

    /**
     *Notifica o efeito Lockin que o turno do herói começou e que é o momento de aumentar o dano da entidade, bem como diminuir o acúmulo.
     *Desenscreve o efeito do Publisher, a classe Combate, caso acúmulo = 0. {@link Combate}
     *@param evento Estado atual da rodada que está ocorrendo, início, ataque do herói, dano do herói, fim da rodada.
     *@param combate classe que controla o sistema de notificações (age como Publisher).
     */
    @Override
    public void serNotificado(Evento evento, Combate combate){
        if(evento == Evento.ATAQUE_HEROI){
            //colocar uma lógica pro ataque aqui
            System.out.println(this.getDono().getName() + " usou Lock-In em si mesmo, e aumentou seu dano causado em " + this.getAcumulo() + "!");
            //isso assumindo que o dano aumentado será o número de acúmulos
            //a gente vai fazer com q a Lock-In tenha uma quantidade de rodadas limites tbm ou é pra sempre?
        }
    }
    
}
