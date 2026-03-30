import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Combate {

    private Heroi heroi;
    private Inimigo inimigo;
    private Tabuleiro tabuleiro;
    private List<Efeito> subscribers = new ArrayList<>();

    //código de cores
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";


    public Combate(Heroi heroi, Inimigo inimigo, Tabuleiro tabuleiro){
        this.heroi = heroi;
        this.inimigo = inimigo;
        this.tabuleiro = tabuleiro;
    }

    public void subscribe(Efeito efeito){
        if(!subscribers.contains(efeito)){
            subscribers.add(efeito);
        }
    }

    public void unsubscribe(Efeito efeito){
        subscribers.remove(efeito);
    }

    public void notify(Evento evento){
        List<Efeito> copiaLista = new ArrayList<>(subscribers);
        for(int i = 0; i < copiaLista.size(); i++){
            Efeito e = copiaLista.get(i);
            e.serNotificado(evento, this);
        }
    }

    Scanner scanner = new Scanner(System.in);
    public void fluxoCombate() throws InterruptedException{
        int nRodada = 1; //contador de rodadas
        int acao = 5;

        while(heroi.estaVivo() && inimigo.estaVivo()){
            
        /*TURNO DO HEROÍ */
            /*PRIMEIRA RODADA */
            if(nRodada == 1){
                System.out.println(COLOR_PURPLE + "\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + heroi.getName() + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n" + COLOR_RESET); 
                System.out.println(COLOR_CYAN + "Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n" + COLOR_RESET);
                System.out.println(COLOR_RED + "\n- MC102: 'Argh, mais um bixo pra lutar contra mim?! Vocês não cansam de sofrer com Python não?'\n- MC102: 'Éh bixo... fica esperto, porque o meu timelimit vai te dar 5 de dano" + COLOR_RESET);
                Thread.sleep(1000);
                comprarCartas(tabuleiro);
                printaStats(heroi, inimigo);
                textoEscolha(heroi, tabuleiro);
                acao = scanner.nextInt();
                this.escolhaAcoesHeroi(acao);
                nRodada += 1;
            }
            /*RESTANTE DAS RODADAS */
            else{
                while (acao !=0 && heroi.getCafeina() > 0){
                    System.err.println(COLOR_GREEN + "\nÉ sua vez novamente!" + COLOR_RESET);
                    Thread.sleep(1000);
                    printaStats(heroi, inimigo);
                    textoEscolha(heroi, tabuleiro);
                    acao = scanner.nextInt();
                    this.escolhaAcoesHeroi(acao);
                    if (algmMorreu(inimigo)){
                        break;
                    }
                }
        
        /*TURNO DOS INIMIGOS */
            inimigo.atacar(heroi, this, tabuleiro);

            
        }
        System.out.println("Uma nova rodada está iniciando!\nÉ a sua vez de jogar!");
        //Turno do herói
        printaStats(heroi, inimigo);
        //a função do inimigo atacar já tá criada dentro da classe
        

    }

    public Entidade getHeroi(){
        return heroi;
    }

    public Entidade getInimigo(){
        return inimigo;
    }

        /*FUNÇÕES UTÉIS PARA A ORGANIZAÇÃO*/
    
    //Verifica a quantidade de cafeína restante e printa o resultado
    public static void infosCafeina(Heroi heroi) throws InterruptedException{
        System.out.println(COLOR_YELLOW + "Cafeína disponível: " + heroi.getCafeina() + COLOR_RESET);
        Thread.sleep(1000);
        if(heroi.getCafeina() == 0){
            System.out.println(COLOR_RED + "\nAcabou sua cafeína :(" + COLOR_RESET);
        }
    }
    
    //Define o que acontece dependendo do número da ação escolhida pelo usuário
    public void escolhaAcoesHeroi(int acao) throws InterruptedException{
        List<Carta> mao = tabuleiro.getMao(); //acessa a mão do jogador
        if (acao == 0){ //escolheu encerrar o turno
            System.out.println(COLOR_RED + "Certeza?! Tá bom... Encerrando turno" + COLOR_RESET);
        } 
        else if(acao - 1 <= mao.size()){ //faz isso apenas se o jogador digitar uma posição válida da mão
            Carta cartaEscolhida = mao.get(acao - 1); //pega a carta específica escolhida
            int custo = cartaEscolhida.getCusto(); //pega o custo da carta
            if (heroi.getCafeina() - custo < 0){ //AQUI ao invés de ser -1 precisa ser - custo da carta, n terminei
                System.out.println(COLOR_RED + "Hm... Você não tem cafeína suficiente pra isso... Escolha uma outra ação (ou tenta pegar um café lá no IC, se a máquina te permitir)" + COLOR_RESET);
                mao.remove(acao - 1); //tira a carta que o jogador tentou usar da mão dele
            }
            else if (acao == 1 || acao == 2 || acao == 3 || acao == 4){
                tabuleiro.usarCarta(acao, tabuleiro, this);
            }
            else { //o usuário (burro) não digitou nenhum dos 3
                System.out.println(COLOR_RED + "Você não escolheu uma ação válida. Por favor, digite um número entre 0, 1, 2, 3 ou 4 e aperte Enter" + COLOR_RESET);
            }
        }
    }

    

    //Retorna true se o inimigo morreu
    public static boolean algmMorreu(Inimigo inimigo){
        if(inimigo.getVida() <= 0){
            System.out.println("\nVida de " + inimigo.getName() + " = 0/" + inimigo.getVida());
            return true;
        }
        return false;
    }

    //Printa nome, vida e escudo tanto do herói, quanto do inimigo
    public static void printaStats(Heroi heroi, Inimigo inimigo) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println(COLOR_GREEN + "\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "/3" + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n" + COLOR_RESET);
        System.out.println(COLOR_RED + "--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo() + "\n" + COLOR_RESET);
    }

    public static void comprarCartas(Tabuleiro tabuleiro){
        for (int i = 0; i < 4; i++) {
            tabuleiro.comprarCarta();
        }
    }

    //Printa as infos pro user saber qual número apertar
    public static void textoEscolha(Heroi heroi, Tabuleiro tabuleiro) throws InterruptedException{
        Thread.sleep(1000); 
        System.out.println("Escolha uma carta (1-4) ou 0 para encerrar:\n(Caso você não tenha cafeína suficiente para nenhuma ação, vai dormir!! (vulgo, encerre seu turno)" + COLOR_CYAN);
        tabuleiro.exibirMao();
        Thread.sleep(1000);
        System.out.println(COLOR_YELLOW + "- Cafeína disponível: " + heroi.getCafeina() + COLOR_RESET+ "\n");
        System.out.println("Digite o número da ação escolhida:");
    }
}
