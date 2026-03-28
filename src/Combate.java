import java.util.ArrayList;
import java.util.List;


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

    public void fluxoCombate() throws InterruptedException{
        int nRodada = 1; //contador de rodadas
        while(heroi.estaVivo() && inimigo.estaVivo()){
            if(nRodada == 1){
                System.out.println(COLOR_PURPLE + "\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + heroi.getName() + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n" + COLOR_RESET); 
                System.out.println(COLOR_CYAN + "Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n" + COLOR_RESET);
                System.out.println(COLOR_RED + "\n- MC102: 'Argh, mais um bixo pra lutar contra mim?! Vocês não cansam de sofrer com Python não?'\n- MC102: 'Éh bixo... fica esperto, porque o meu timelimit vai te dar 5 de dano" + COLOR_RESET);
                Thread.sleep(1000);
                comprarCartas(tabuleiro);
                printaStats(heroi, inimigo);

            }
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

    public static void textoEscolha(Heroi heroi, Tabuleiro tabuleiro) throws InterruptedException{
        Thread.sleep(1000); 
        System.out.println("Escolha uma carta (1-4) ou 0 para encerrar:\n(Caso você não tenha cafeína suficiente para nenhuma ação, vai dormir!! (vulgo, encerre seu turno)" + COLOR_CYAN);
        tabuleiro.exibirMao();
        Thread.sleep(1000);
        System.out.println(COLOR_YELLOW + "- Cafeína disponível: " + heroi.getCafeina() + COLOR_RESET+ "\n");
        System.out.println("Digite o número da ação escolhida:");
    }
}
