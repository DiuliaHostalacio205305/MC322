import java.util.List;
import java.util.Scanner;

public class App {

    //Definidores de cor
    public static final String colorReset = "\u001B[0m";
    public static final String colorPurple = "\u001B[35m";
    public static final String colorCyan = "\u001B[36m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorYellow = "\u001B[33m";
    public static final String colorLightGreen = "\u001B[92m";
    public static final String colorOrange = "\u001B[38;5;208m";
    public static final String colorPink = "\u001B[95m";

    public static void main(String[] args) throws InterruptedException{
        
        //Pré definições
        Heroi heroi = new Heroi("Calouro", 30, 0, 4, 3);
        Inimigo inimigo = new Inimigo("MC102", 25, 0, 25);
        Tabuleiro tabuleiro = new Tabuleiro(heroi, inimigo);
        
        int hpInimigo = inimigo.getVida();
        int hpHeroi = heroi.getVida();
        tabuleiro.iniciarPartida(); //Preenche e embaralha o deck de cartas

        int acao = 5;

        //Texto de inicialização
        System.out.println(colorCyan + "Olá! Seja bem-vindo ao curso de Computação da Unicamp!");
        System.out.println("Para graduar você precisará passar por diversos desafios, bosses, irritações, surtos... Hm, quer dizer, adversários ótimos que te fortalecerão nessa aventura!");
        System.out.println("Hoje, você pode até estar começando como um jovem e ingênuo programador de Python, ou apenas entusiasta da programação... mas não se preocupe, logo você perceberá que nem tudo é tão fácil quanto Python parece ser\n");
        System.out.println(colorPurple + "Cada batalha será um passo em direção ao seu sonho de se tornar um Desenvolvedor Sênior, e cada inimigo que derrotar te deixará mais perto desse objetivo (e um pouco mais doido também)\n" + colorReset);
        System.out.println("Durante os combates, você começa atacando, e pode escolher entre:\n" + colorLightGreen + "1 - Atacar\n" + colorCyan + "2 - Utilizar um escudo\n" + colorRed + "3 - Encerrar seu turno\n\n" + colorYellow + "Lembrando que cada ação gastará uma certa quantidade da sua cafeína total, o cafézinho que você toma do IC... então gaste com sabedoria, porque nem sempre a máquina de café funciona...\n" + colorReset);
        System.out.println("Pronto para começar?\nEscolha um nome para o seu personagem:");
        
        //Define o nome do personagem
        Scanner scanner = new Scanner(System.in);
        String nome_personagem = scanner.nextLine(); //lê o que foi digitado pelo usuário
        heroi.setNome(nome_personagem); //atribuí o novo nome ao personagem

        /*PRIMEIRA RODADA*/
        System.out.println(colorPurple + "\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + nome_personagem + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n" + colorReset); 
        System.out.println(colorCyan + "Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n" + colorReset);
        System.out.println(colorRed+ "- MC102: 'Éh bixo... fica esperto, porque o meu timelimit vai te dar 5 de dano" + colorReset);
        Thread.sleep(3000);
        comprarCartas(tabuleiro);
        printaStats(heroi, inimigo);
        textoEscolha(heroi, tabuleiro);
        acao = scanner.nextInt();
        escolhaAcoesHeroi(acao, heroi, inimigo, hpInimigo, tabuleiro);

        /*RODADAS SEGUINTES*/
        while(heroi.estaVivo() && inimigo.estaVivo()){ //agora roda até um dos 2 morrer

            //Turno do heroí
            while (acao !=0 && heroi.getCafeina() > 0){
                System.err.println(colorGreen + "\nÉ sua vez novamente!" + colorReset);
                Thread.sleep(3500);
                printaStats(heroi, inimigo);
                textoEscolha(heroi, tabuleiro);
                acao = scanner.nextInt();
                escolhaAcoesHeroi(acao, heroi, inimigo, hpInimigo, tabuleiro);
                if (algmMorreu(inimigo, hpInimigo)){
                    break;
                }
            }

            //Turno do inimigo
            if(inimigo.getVida() > 0){ //o inimigo só ataca se estiver vivo
                System.out.println("\nAgora é a vez de " + inimigo.getName());
                System.out.println(colorRed + "Ele usou: 'time limit', você sofreu 5 de dano. Ouch!" + colorReset);
                inimigo.atacar(heroi); //colocar uma função random aq pra variar entre ataque e escudo pro inimigo
                if(heroi.getVida() <= 0){
                    System.out.println("Vida de " + heroi.getName() + " = 0/" + hpHeroi);
                    break;
                }
                System.out.println(colorGreen + "Vida de " + heroi.getName() + " = " + heroi.getVida() + "/" + hpHeroi + colorReset);
                Thread.sleep(3500);
            }

            //Reseta a ação e a cafeína e o escudo
            acao = 5;
            heroi.setCafeina(4);
            heroi.resetaEscudo();
            tabuleiro.limparMao(); //Limpa a mao no final do turno
            comprarCartas(tabuleiro);
            System.out.println(colorRed+ "\n- MC102: 'Argh, mais um bixo pra lutar contra mim?! Vocês não cansam de sofrer com Python não?'\n- MC102: 'Éh bixo... fica esperto, porque o meu timelimit vai te dar 5 de dano" + colorReset);
        }
    
        if(heroi.getVida() <= 0){
            System.out.println(colorRed + "\nOh nãooo... \nVocê reprovou :( \nPelo menos da para tentar de novo semestre que vem!" + colorReset);
        }     
        if(inimigo.getVida() <= 0){
                System.out.println(colorGreen + "\nParabéns!\nVocê passou na disciplina:)\nAproveite as suas férias!" + colorReset);
        }
        scanner.close();
    }


    /*FUNÇÕES UTÉIS PARA A ORGANIZAÇÃO*/
    
    //Verifica a quantidade de cafeína restante e printa o resultado
    public static void infosCafeina(Heroi heroi) throws InterruptedException{
        System.out.println(colorYellow + "Cafeína disponível: " + heroi.getCafeina() + colorReset);
        Thread.sleep(2500);
        if(heroi.getCafeina() == 0){
            System.out.println(colorRed + "\nAcabou sua cafeína :(" + colorReset);
        }
    }
    
    //Define o que acontece dependendo do número da ação escolhida pelo usuário
    public static void escolhaAcoesHeroi(int acao, Heroi heroi, Inimigo inimigo, int hpInimigo, Tabuleiro tabuleiro) throws InterruptedException{
        List<Carta> mao = tabuleiro.getMao(); //acessa a mão do jogador
        if (acao == 0){ //escolheu encerrar o turno
            System.out.println(colorRed + "Certeza?! Tá bom... Encerrando turno" + colorReset);
        } 
        else if(acao - 1 <= mao.size()){ //faz isso apenas se o jogador digitar uma posição válida da mão
            Carta cartaEscolhida = mao.get(acao - 1); //pega a carta específica escolhida
            int custo = cartaEscolhida.getCusto(); //pega o custo da carta
            if (heroi.getCafeina() - custo < 0){ //AQUI ao invés de ser -1 precisa ser - custo da carta, n terminei
                System.out.println(colorRed + "Hm... Você não tem cafeína suficiente pra isso... Escolha uma outra ação (ou tenta pegar um café lá no IC, se a máquina te permitir)" + colorReset);
                mao.remove(acao - 1); //tira a carta que o jogador tentou usar da mão dele
            }
            else if (acao == 1 || acao == 2 || acao == 3 || acao == 4){
                tabuleiro.usarCarta(acao, tabuleiro);
            }
            else { //o usuário (burro) não digitou nenhum dos 3
                System.out.println(colorRed + "Você não escolheu uma ação válida. Por favor, digite um número entre 0, 1, 2, 3 ou 4 e aperte Enter" + colorReset);
            }
        }
    }

    //Printa nome, vida e escudo tanto do herói, quanto do inimigo
    public static void printaStats(Heroi heroi, Inimigo inimigo){
        System.out.println(colorGreen + "\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "/3" + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n" + colorReset);
        System.out.println(colorRed + "--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo() + "\n" + colorReset);
    }

    //Retorna true se o inimigo morreu
    public static boolean algmMorreu(Inimigo inimigo, int hpInimigo){
        if(inimigo.getVida() <= 0){
            System.out.println("\nVida de " + inimigo.getName() + " = 0/" + hpInimigo);
            return true;
        }
        return false;
    }

    //Printa as infos pro user saber qual número apertar
    public static void textoEscolha(Heroi heroi, Tabuleiro tabuleiro){
        System.out.println("Escolha uma carta (1-4) ou 0 para encerrar:\n(Caso você não tenha cafeína suficiente para nenhuma ação, vai dormir!! (vulgo, encerre seu turno)" + colorCyan);
        tabuleiro.exibirMao();
        System.out.println(colorYellow + "- Cafeína disponível: " + heroi.getCafeina() + colorReset+ "\n");
        System.out.println("Digite o número da ação escolhida:");
    }

    public static void comprarCartas(Tabuleiro tabuleiro){
        for (int i = 0; i < 4; i++) {
            tabuleiro.comprarCarta();
        }
    }
}

//comment