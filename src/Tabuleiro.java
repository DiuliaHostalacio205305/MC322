import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tabuleiro {
    private Heroi heroi;
    private Inimigo inimigo;
    private Stack<Carta> compra = new Stack<>();
    private Stack<Carta> descarte = new Stack<>();
    private List<Carta> mao = new ArrayList<>();

    public Tabuleiro(Heroi heroi, Inimigo inimigo){
        this.heroi = heroi;
        this.inimigo = inimigo;
    }

    public Heroi getHeroi(){
        return heroi;
    }

    public Inimigo getInimigo(){
        return inimigo;
    }

    public void iniciarPartida(){
        
        //Criação das cartas de dano
        compra.push(new CartaDano("Ir na monitoria do Gustavo", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 3, 6));
        compra.push(new CartaDano("Ir na monitoria da Lia", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 2, 5));
        compra.push(new CartaDano("Ir na monitoria do Giovanne", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 3, 6));
        compra.push(new CartaDano("Ir na monitoria da Mariana", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 2, 5));
        compra.push(new CartaDano("Ir na aula", "Você vai na aula e aprende a matéria \nCusto: 2 cafeína \nDano: 3", 2, 3));
        compra.push(new CartaDano("Pesquisar na Internet", "Você da uma pesquisada para resolver uma dúvida \nCusto: 1 cafeína \nDano: 3", 1, 3));
        compra.push(new CartaDano("Perguntar para o coleguinha (sem plágio)", "Você conversa com um amigo e descobre como ele já tinha resolvido um problema parecido \nCusto: 1 cafeína \nDano: 2", 1, 2));
        

        //Criação das cartas de escudo
        compra.push(new CartaEscudo("Baixar o VScode", "Você baixa o VScode, facilitando muito sua vida ao codar \nCusto: 1 cafeína \nEscudo: 1", 1, 2 ));
        compra.push(new CartaEscudo("Comprar um notebook com 16gb de RAM", "Você junta uma grana e compra um notebook potente \nCusto: 2 cafeína \nEscudo: 3", 2, 3 ));
        compra.push(new CartaEscudo("Mudar para Linux", "Você toma a decisão difícil de abandonar o Windows e se arriscar no mundo do Linux \nCusto: 2 cafeína \nEscudo: 3", 2, 3 ));
        compra.push(new CartaEscudo("Desinstalar o TikTok", "Você toma vergonha na cara e desisntala o TikTok para poder dar Lock-in \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        compra.push(new CartaEscudo("Desinstalar o Instagram", "Você toma vergonha na cara e desisntala o Instagram para poder dar Lock-in \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        compra.push(new CartaEscudo("Desinstalar o Twitter", "Você toma vergonha na cara e desisntala o Instagram para poder dar Lock-in \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        Collections.shuffle(compra);
    }

    public void comprarCarta(){
        if (!compra.isEmpty()){
            mao.add(compra.pop());
        }
        //quando a pilha de compras está vazia
        else{
            
            while(!descarte.isEmpty()){
                compra.push(descarte.pop());
            }
            Collections.shuffle(compra);
            mao.add(compra.pop());
        }
    }

    public void usarCarta(int indice, Tabuleiro tabuleiro){
        if (indice - 1 >= 0 && indice <= mao.size()){ //lembrar que o indice começa em 0
            Carta cartaEscolhida = mao.remove(indice - 1);
            cartaEscolhida.usar(tabuleiro);
            descarte.push(cartaEscolhida);
        }
    }

    //Mostra a mão do jogador
    public void exibirMao(){
        System.out.println("\n--- Sua Mão ---\n");

        for (int i = 1; i <= mao.size(); i++) {
            Carta carta = mao.get(i - 1);
            //Exibe o índice (i) para o jogador saber o que digitar
            System.out.println("(" + i + ") " + carta.getName());
            System.out.println("Descrição: " + carta.getDescricao() + "\n");
        }
        System.out.println("--------------------\n");

    }

    //Limpa a mão do jogador no fim da rodada
    public void limparMao(){
        while (!mao.isEmpty()) {
        descarte.push(mao.remove(0)); //Remove da mão e joga no descarte quando acaba o turno do heroí
        }
    }

    public List<Carta> getMao(){
        return mao;
    }
}



/*Cartas de ataque:
    Usar o github
    Virar a noite codando - da 10 de dano mas toma 5



Cartas de escudo:
    


Cartas de veneno:




*/
