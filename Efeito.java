public class Efeito {
    
    private String nome;
    private String descricao;
    private Entidade dono;
    private int acumulos;

    public Efeit(String nome, String descricao, Entidade dono, int acumulos){
        this.nome = nome;
        this.dono = dono;
        this.acumulos = acumulos;
        this.descricao = descricao;
    }

    public String geString(){
        return nome + descricao + acumulos;
    }

    public String getName(){
        return nome;
    }

    public int getAcumulo(){
        return acumulos;
    }

    public void serNotificado(){
        //terminar
    }
}
