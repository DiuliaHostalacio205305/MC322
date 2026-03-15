public class Carta {
    
    private String nome;
    private String descricao;
    private int custo;

    public Carta(String nome, String descricao, int custo){
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
    }

    public void usar(Tabuleiro tabuleiro){
        System.out.println("Usando a carta: " + nome + "\nCusto: " + custo);
        System.out.println("Sobre a carta: " + descricao);
    }

    public String getName(){
        return nome;
    }

    public int getCusto(){
        return custo;
    }

}
