public class Lockin extends Efeito{

    public Lockin(String nome, String descricao, Entidade dono, int acumulos){
        super(nome, descricao, dono, acumulos);
    }

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
