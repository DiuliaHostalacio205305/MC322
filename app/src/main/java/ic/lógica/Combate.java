package ic.lógica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ic.cartas.Carta;
import ic.efeito.Efeito;
import ic.entidades.Entidade;
import ic.entidades.Heroi;
import ic.inimigos.Inimigo;
import ic.organização.Cores;

/**
 * Gerencia o fluxo de batalha entre o Herói e o Inimigo
 * Esta classe implementa o padrão Observer, agindo como o Publisher, para notificar efeitos 
 */
public class Combate {

    private Heroi heroi;
    private Inimigo inimigo;
    private Tabuleiro tabuleiro;
    /** 
     * Lista de observadores (Efeitos) que aguardam notificações de eventos 
     * como início ou fim de turno
     */
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

    //inicialização do scanner para a leitura do terminal
    private Scanner scanner;

    /**
     * Construtor da classe Combate
     * @param heroi O herói que participará da luta
     * @param inimigo O inimigo a ser combatido
     * @param tabuleiro O tabuleiro de cartas associado ao combate
     */
    public Combate(Heroi heroi, Inimigo inimigo, Tabuleiro tabuleiro, Scanner scanner){
        this.heroi = heroi;
        this.inimigo = inimigo;
        this.tabuleiro = tabuleiro;
        this.scanner = scanner;
    }

    /**
     * Inscreve um efeito para receber notificações de eventos de combate
     * @param efeito O efeito que deseja observar o combate
     */
    public void subscribe(Efeito efeito){
        if(!subscribers.contains(efeito)){
            subscribers.add(efeito);
        }
    }

    /**
     * Remove um efeito da lista de notificações
     * @param efeito O efeito a ser removido
     */
    public void unsubscribe(Efeito efeito){
        subscribers.remove(efeito);
    }

    /**
     * Notifica todos os efeitos inscritos sobre a ocorrência de um evento específico
     * Utiliza uma cópia da lista para evitar erros de modificação concorrente durante o loop
     * @param evento O tipo de evento ocorrido (Ex: início ou fim de turno)
     */
    public void notify(Evento evento){
        List<Efeito> copiaLista = new ArrayList<>(subscribers);
        for(int i = 0; i < copiaLista.size(); i++){
            Efeito e = copiaLista.get(i);
            e.serNotificado(evento, this);
        }
    }

    /**
     * Executa o loop principal do combate por turnos até que uma das entidades morra
     * Controla as fases de início de turno, ação do herói, ação do inimigo e fim de turno
     * @throws InterruptedException Caso ocorra uma interrupção durante as pausas de Thread.sleep
     */
    public void fluxoCombate() throws InterruptedException{
        int nRodada = 1; //contador de rodadas
        int acao = 5;

        while(heroi.estaVivo() && inimigo.estaVivo()){
        //Avisa que um novo turno começou
        this.notify(Evento.INICIO);

        /*TURNO DO HEROÍ */
            /*PRIMEIRA RODADA */
            if(nRodada == 1){
                inimigo.falaRodada1(heroi);
                inimigo.randomizarAtaque();
                inimigo.imprimeAcaoInimigo(inimigo.getIntencao());
                
                Thread.sleep(1000);
                comprarCartas(tabuleiro);
                printaStats(heroi, inimigo);
                textoEscolha(heroi, tabuleiro);
                acao = scanner.nextInt();
                this.escolhaAcoesHeroi(acao);
                nRodada += 1;
                if (algmMorreu(inimigo)){
                    break;
                }
            }
            /*RESTANTE DAS RODADAS */
            if(nRodada != 1){
                while (acao !=0 && heroi.getCafeina() > 0 && inimigo.getVida() > 0){
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
                if (algmMorreu(inimigo)){
                    break;
                }
                //nRodada += 1; nn sei pq da pau :(
            }

            /*TURNO DOS INIMIGOS */
            inimigo.atacar(heroi, this, tabuleiro);
            if(heroi.getVida() <= 0 && inimigo.getVida() > 0){
                    System.out.println("Vida de " + heroi.getName() + " = 0/" + heroi.getVida());
                    break;
                }
            System.out.println(COLOR_GREEN + "\nVida de " + heroi.getName() + " = " + heroi.getVida() + "/" + heroi.getvidaMax() + COLOR_RESET);
            Thread.sleep(1000);
            
            //Avisa que o turno terminou
            this.notify(Evento.FIM);

            //Reseta a ação e a cafeína e o escudo
            acao = 5;
            heroi.setCafeina(4);
            heroi.resetaEscudo();
            tabuleiro.limparMao(); //Limpa a mao no final do turno
            comprarCartas(tabuleiro);
            System.out.println(COLOR_GREEN + "\nRODADA " + nRodada);
            inimigo.randomizarAtaque();
            inimigo.imprimeAcaoInimigo(inimigo.getIntencao());
        }
        if(heroi.getVida() <= 0){
            System.out.println(COLOR_RED + "\nOh nãooo... \nVocê reprovou :( \nPelo menos da para tentar de novo semestre que vem!" + COLOR_RESET);
        }
        if(inimigo.getVida() <= 0){
                System.out.println(Cores.COLOR_GREEN + "\nParabéns!\nVocê passou na disciplina:)\nAproveite as suas férias!" + COLOR_RESET);
        }
        //fecha o scanner de leitura de terminal
        //scanner.close();
    }

    /** @return O herói do combate. */
    public Entidade getHeroi(){
        return heroi;
    }

    /** @return O inimigo do combate. */
    public Inimigo getInimigo(){
        return inimigo;
    }

    /*FUNÇÕES UTÉIS PARA A ORGANIZAÇÃO*/
    
   /**
     * Exibe informações sobre a cafeína restante do herói
     * @param heroi O herói a ter a cafeína checada
     * @throws InterruptedException Devido ao uso de Thread.sleep
     */
    public static void infosCafeina(Heroi heroi) throws InterruptedException{
        System.out.println(COLOR_YELLOW + "Cafeína disponível: " + heroi.getCafeina() + COLOR_RESET);
        Thread.sleep(1000);
        if(heroi.getCafeina() == 0){
            System.out.println(COLOR_RED + "\nAcabou sua cafeína :(" + COLOR_RESET);
        }
    }
    
    /**
     * Define o que acontece dependendo do número da ação escolhida pelo usuário
     * @param acao O índice da carta na mão (1-4) ou 0 para encerrar o turno
     * @throws InterruptedException Devido ao uso de Thread.sleep
     */
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

    /**
     * Verifica se o inimigo foi derrotado
     * @param inimigo O inimigo a ser verificado
     * @return true se a vida do inimigo for menor ou igual a zero, false caso contrário
     */
    public static boolean algmMorreu(Inimigo inimigo){
        if(inimigo.getVida() <= 0){
            System.out.println("\nVida de " + inimigo.getName() + " = 0/" + inimigo.getvidaMax());
            return true;
        }
        return false;
    }

    /**
     * Imprime no terminal os atributos atuais (Vida, Escudo, Cafeína, Efeitos) do herói e do inimigo
     * @param heroi O herói para exibir status
     * @param inimigo O inimigo para exibir status
     * @throws InterruptedException Para controle de tempo da interface
     */
    public static void printaStats(Heroi heroi, Inimigo inimigo) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println(COLOR_GREEN + "\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "/3" + "\n- Cafeína: " + heroi.getCafeina() + "\n- Acúmulo de Lock-in: " + heroi.getLockin() + "\n- Acumulo de Burnout: " + heroi.getBurnout() + "\n\n--------------------\n" + COLOR_RESET);
        System.out.println(COLOR_RED + "--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo() + "\n- Acumulo de Lock-in: " + inimigo.getLockin() + "\n- Acúmulo de Veneno: " + inimigo.getBurnout() + "\n" + COLOR_RESET);
    }

    /**
     * Comanda o tabuleiro para que o jogador compre a quantidade inicial de cartas
     * @param tabuleiro O tabuleiro onde as cartas serão compradas
     */
    public static void comprarCartas(Tabuleiro tabuleiro){
        for (int i = 0; i < 4; i++) {
            tabuleiro.comprarCarta();
        }
    }

    /**
     * Printa o menu de opções de cartas e status de cafeína para o usuário
     * @param heroi O herói para checar cafeína
     * @param tabuleiro O tabuleiro para exibir a mão atual
     * @throws InterruptedException Para controle de tempo da interface
     */
    public static void textoEscolha(Heroi heroi, Tabuleiro tabuleiro) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("Escolha uma carta (1-4) ou 0 para encerrar:\n(Caso você não tenha cafeína suficiente para nenhuma ação, vai dormir!! (vulgo, encerre seu turno)" + COLOR_CYAN);
        tabuleiro.exibirMao();
        Thread.sleep(1000);
        System.out.println(COLOR_YELLOW + "- Cafeína disponível: " + heroi.getCafeina() + COLOR_RESET+ "\n");
        System.out.println("Digite o número da ação escolhida:");
    }
}