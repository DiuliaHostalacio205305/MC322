public class CartaForca extends Carta{
    
    private int strenght; 

    public CartaForca(String nome, String descricao, int custo, int strenght){
        super(nome, descricao, custo);
        this.strenght = strenght;
    }

    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println("Usando a carta" + getName() + ". Agora está mais forte!");
        System.out.println("Você aumentou sua força em " + strenght + "pontos de força!\nAgora seus ataques darão mais dano!");
        Forca novaForca = new Forca("colocar nome", "colocar descricao", tabuleiro.getHeroi(), strenght);
        tabuleiro.getHeroi().usarEfeito(novaForca);
        combate.subscribe(novaForca); //inscreve a força para ser notificada
    }

}
