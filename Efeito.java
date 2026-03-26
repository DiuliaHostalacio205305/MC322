public abstract class Efeito {
    
    private String nome;
    private String descricao;
    private Entidade dono;
    private int acumulos;

    public Efeito(String nome, String descricao, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
        this.descricao = descricao;
    }

    public String getString(){
        return nome + descricao + acumulos;
    }

    public String getName(){
        return nome;
    }

    public Entidade getDono(){
        return dono;
    }

    public int getAcumulo(){
        return acumulos;
    }

    public abstract void serNotificado(Evento evento, Combate combate); //vai ser subscrito em todos os efeitos que herdarem dessa classe
}
