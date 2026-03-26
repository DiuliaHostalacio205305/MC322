public class Burnout extends Efeito {
    //efeito análogo ao veneno 
    public Burnout(String nome, String descricao, Entidade dono, int acumulos){
        super(nome, descricao, dono, acumulos);
    }

    @Override
    public void serNotificado(Evento evento, Combate combate){
        if(evento == Evento.FIM){ //se estiver no final da rodada
            int dano = this.getAcumulo(); //no caso, o dano que a entidade sofrerá é o acúmulo da rodada
            dono.receberDano();
            //fazer uma parte pra diminuir o acumulo
            this.acumulo = acumulo - 1; //n sei se isso funciona
        }
    }
}
