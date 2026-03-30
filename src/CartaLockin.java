public class CartaLockin extends Carta{
    
    private int strenght; 

    public CartaLockin(String nome, String descricao, int custo, int strenght){
        super(nome, descricao, custo);
        this.strenght = strenght;
    }

    @Override
    public void usar(Tabuleiro tabuleiro, Combate combate){
        System.out.println("Usando a carta" + getName() + ". Agora está mais forte!");
        System.out.println("Você aumentou sua Lock-in em " + strenght + "pontos de Lock-in!\nAgora seus ataques darão mais dano!");
        Lockin novaLockin = new Lockin("colocar nome", "colocar descricao", tabuleiro.getHeroi(), strenght);
        tabuleiro.getHeroi().usarEfeito(novaLockin);
        combate.subscribe(novaLockin); //inscreve a Lock-in para ser notificada
    }

}
