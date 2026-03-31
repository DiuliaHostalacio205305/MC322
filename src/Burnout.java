public class Burnout extends Efeito {
    //efeito análogo ao veneno 
    public Burnout(String nome, String descricao, Entidade dono, int acumulos){
        super(nome, descricao, dono, acumulos);
    }

    @Override
    public void serNotificado(Evento evento, Combate combate){
        if(evento == Evento.FIM){ //se estiver no final da rodada
            int dano = this.getAcumulo(); //no caso, o dano que a entidade sofrerá é o acúmulo da rodada
            getDono().receberDano(dano);
            
            this.setAcumulo(this.getAcumulo() - 1); //seta um novo acumulo retirando 1
            
            //acho que vai precisar de algo que barre no 0, ou reset pra que o acumulo minimo seja 0
            if(this.getAcumulo() <= 0){
                System.out.println("O efeito do veneno acabou!"); //mudar esse print
                this.getDono().excluirEfeito(this);
                combate.unsubscribe(this);
            }
        }
    }
}
