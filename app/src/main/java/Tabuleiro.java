import java.util.Stack;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe que contém todas as "peças" do jogo, cartas de dano, escudo, burnout e lockin, herói e inimigo.
 * É também a classe que controla a mão do jogador, agindo como um baralho (compra, descarte e reshuffle). {@link Stack} {@link List}.
 */

public class Tabuleiro {
    private Heroi heroi;
    private Stack<Carta> compra = new Stack<>();
    private Stack<Carta> descarte = new Stack<>();
    private List<Carta> mao = new ArrayList<>();

    public Tabuleiro(Heroi heroi){
        this.heroi = heroi;
    }

    /**
     * Acessa e retorna o herói do jogo
     * @return O herói do jogo
     */
    public Heroi getHeroi(){
        return heroi;
    }

    ///**
    // * Acessa e retorna o inimigo do jogo
    // * @return O inimigo do jogo
    // */
    //public Inimigo getInimigo(){
    //    return inimigo;
    //}

    /**
     * Inicia a partida, instanciando as entidades necessárias e criando todas as cartas do baralho disponíveis.
     */
    public void iniciarPartida(){
        
        //Criação das cartas de dano
        compra.push(new CartaDano("Ir na monitoria do Gustavo", "Você vai na monitoria e tira uma dúvida \nCusto: 3 cafeína \nDano: 6", 3, 6));
        compra.push(new CartaDano("Ir na monitoria da Lia", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 2, 5));
        compra.push(new CartaDano("Ir na monitoria do Giovanne", "Você vai na monitoria e tira uma dúvida \nCusto: 3 cafeína \nDano: 6", 3, 6));
        compra.push(new CartaDano("Ir na monitoria da Mariana", "Você vai na monitoria e tira uma dúvida \nCusto: 2 cafeína \nDano: 5", 2, 5));
        compra.push(new CartaDano("Ir na aula", "Você vai na aula e aprende a matéria \nCusto: 2 cafeína \nDano: 3", 2, 3));
        compra.push(new CartaDano("Pesquisar na Internet", "Você da uma pesquisada para resolver uma dúvida \nCusto: 1 cafeína \nDano: 3", 1, 3));
        compra.push(new CartaDano("Perguntar para o coleguinha (sem plágio)", "Você conversa com um amigo e descobre como ele já tinha resolvido um problema parecido \nCusto: 1 cafeína \nDano: 2", 1, 2));
        //carta nova
        compra.push(new CartaDano("Ler um livro", "Tal como seus antepassados, você decide pegar o livro 'Entendendo algoritimos' e ler \nCusto: 3 cafeína \nDano: 5", 3, 5));
        compra.push(new CartaDano("Olhar os slides", "Você decide dar uma relida nos slides de aula \nCusto: 1 cafeína \nDano: 2", 1, 2));
        

        //Criação das cartas de escudo
        compra.push(new CartaEscudo("Baixar o VScode", "Você baixa o VScode, facilitando muito sua vida ao codar \nCusto: 1 cafeína \nEscudo: 2", 1, 2 ));
        compra.push(new CartaEscudo("Comprar um notebook com 16gb de RAM", "Você junta uma grana e compra um notebook potente \nCusto: 2 cafeína \nEscudo: 3", 2, 3 ));
        compra.push(new CartaEscudo("Mudar para Linux", "Você toma a decisão difícil de abandonar o Windows e se arriscar no mundo do Linux \nCusto: 2 cafeína \nEscudo: 3", 2, 3 ));
        compra.push(new CartaEscudo("Desinstalar o TikTok", "Você toma vergonha na cara e desinstala o TikTok para poder focar mais \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        compra.push(new CartaEscudo("Desinstalar o Instagram", "Você toma vergonha na cara e desinstala o Instagram para poder focar mais \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        compra.push(new CartaEscudo("Desinstalar o Twitter", "Você toma vergonha na cara e desinstala o Twitter para poder focar mais \nCusto: 1 cafeína \nEscudo: 1", 1, 1 ));
        //carta nova
        compra.push(new CartaEscudo("Comprar um teclado gamer", "Ele ajuda em algo na prática? Não. Mas você se sente psicologicamente mais preparado para codar \nCusto: 2 cafeínas \nEscudo: 2", 2, 2 ));

        
        //Criação das cartas de Burnout (Veneno)
        compra.push(new CartaBurnout("Reclamar com o Coordenador do curso", "Você vai até a sala do Coordenador reclamar da dificuldade da disciplina, deixando ela mais fácil (momentâneamente) \nCusto: 3 cafeínas \nVeneno: 4", 3, 4, null));
        compra.push(new CartaBurnout("Reclamar com o professor", "Você vai até a sala do Professor reclamar da dificuldade da disciplina, deixando ela mais fácil (momentâneamente) \nCusto: 2 cafeínas \nVeneno: 3", 2, 3, null));
        //carta nova
        compra.push(new CartaBurnout("Criar grupo de estudos", "Você e alguns amigos criam um grupo de estudos para a disciplina, deixando ela mais fácil (momentâneamente) \nCusto: 3 cafeínas \nVeneno: 5", 3, 5, null));


        //Criação das cartas de Lock-In
        compra.push(new CartaLockin("Tirar o fim de semana pra estudar", "Você dá Lock-In no fim de semana, aumentando sua eficiência \nCusto: 3 cafeínas \nBonûs de força: 3", 3, 3, heroi));
        compra.push(new CartaLockin("Tirar o dia pra estudar", "Você dá Lock-In durante o dia, aumentando sua eficiência \nCusto: 2 cafeínas \nBonûs de força: 2", 2, 2, heroi));
        //carta nova
        compra.push(new CartaLockin("Virar a noite no IC", "O que você faz das 23h até as 6h da manhã? Exatamente, nada! Por isso você aproveita esse tempo para dar um Lock-In \nCusto: 3 cafeínas \nBonûs de força: 2", 3, 2, heroi));
        


        Collections.shuffle(compra);
    }

    /**
     * Compra uma carta para o jogador, adicionando a carta comprada à mão do herói.
     */
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

    /**
     * Permite a utilização da carta que o jogador escolher.
     * @param indice Posição da carta que o jogador escolheu na mão do herói {@link List}.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     * @param combate Classe que controla o fluxo do jogo.
     */
    public void usarCarta(int indice, Tabuleiro tabuleiro, Combate combate){
        if (indice - 1 >= 0 && indice <= mao.size()){ //lembrar que o indice começa em 0
            Carta cartaEscolhida = mao.remove(indice - 1);
            cartaEscolhida.usar(tabuleiro, combate);
            descarte.push(cartaEscolhida);
        }
    }

    /**
     * Permite a visualização da mão do herói, imprimindo as opções de escolha atuais.
     * @throws InterruptedException
     */
    public void exibirMao() throws InterruptedException{
        System.out.println("\n--- Sua Mão ---\n");

        for (int i = 1; i <= mao.size(); i++) {
            Carta carta = mao.get(i - 1);
            //Exibe o índice (i) para o jogador saber o que digitar
            System.out.println("(" + i + ") " + carta.getName());
            System.out.println("Descrição: " + carta.getDescricao() + "\n");
            Thread.sleep(500);
        }
        System.out.println("--------------------\n");

    }

    /**
     * Limpa a mão do jogador ao fim da rodada
     */
    public void limparMao(){
        while (!mao.isEmpty()) {
        descarte.push(mao.remove(0)); //Remove da mão e joga no descarte quando acaba o turno do heroí
        }
    }

    /**
     * Acessa e retorna a mão do herói, isto é, as cartas disponíveis para escolha
     * @return A mão do herói
     */
    public List<Carta> getMao(){
        return mao;
    }
}



/*Cartas de ataque:
    Usar o github
    Virar a noite codando - da 10 de dano mas toma 5



Cartas de escudo:
    


Cartas de veneno:
compra.push(new CartaBurnout("Ficar 5h tentando debugar e não achar o bug", "Você tenta compilar seu código e descobre um bug, mas fica 5h tentando achar o erro e não consegue", 3, 3, inimigo)); //todas as que eu criar aqui serão pro herói usar
compra.push(new CartaBurnout("Tentar aprender do zero a usar arquivos .json pra um trabalho que vence AMANHÃ (spoiler: definitivamente você não vai ter muito sono essa noite)", "Você descobriu AGORA que seu trabalho pra amanhã precisa que vc use arquivos .json pra salvar dados, mas vc nunca fez isso antes e precisa aprender o mais rápido possível", 0, 4, heroi))



*/
