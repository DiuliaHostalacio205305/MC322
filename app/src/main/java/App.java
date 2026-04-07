import java.util.Scanner;

public class App {

    //Definidores de cor
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";

    /**
    *Função main, a primeira a ser chamada que permite o código rodar
    *@throws InterruptedException Para controle de tempo da interface
    */
    public static void main(String[] args) throws InterruptedException{
        
        //Pré definições
        Heroi heroi = new Heroi("Calouro", 30, 0, 4, 3, 30);
        Inimigo inimigo = new Inimigo("MC102", 25, 0, 25);
        Tabuleiro tabuleiro = new Tabuleiro(heroi, inimigo); //é o baralho de cartas e personagens
        Combate combate = new Combate(heroi, inimigo, tabuleiro); //é o controlador do fluxo de batalha e publisher
        
        tabuleiro.iniciarPartida(); //Preenche e embaralha o deck de cartas

        //Texto de inicialização
        System.out.println(COLOR_CYAN + "Olá! Seja bem-vindo ao curso de Computação da Unicamp!");
        System.out.println("Para graduar você precisará passar por diversos desafios, bosses, irritações, surtos... Hm, quer dizer, adversários ótimos que te fortalecerão nessa aventura!");
        System.out.println("Hoje, você pode até estar começando como um jovem e ingênuo programador de Python, ou apenas entusiasta da programação... mas não se preocupe, logo você perceberá que nem tudo é tão fácil quanto Python parece ser\n");
        System.out.println(COLOR_PURPLE + "Cada batalha será um passo em direção ao seu sonho de se tornar um Desenvolvedor Sênior, e cada inimigo que derrotar te deixará mais perto desse objetivo (e um pouco mais doido também)\n" + COLOR_RESET);
        System.out.println("Durante os combates, você começa atacando, e pode escolher entre:\n" + COLOR_LIGHT_GREEN + "- Carta de Ataque\n" + COLOR_CYAN + "- Carta de Efeito\n"  + COLOR_ORANGE + "- Carta de Escudo\n" + COLOR_RED + "- Encerrar seu turno\n\n" + COLOR_YELLOW + "Lembrando que cada ação gastará uma certa quantidade da sua cafeína total, o cafézinho que você toma do IC... então gaste com sabedoria, porque nem sempre a máquina de café funciona...\n" + COLOR_RESET);
        System.out.println("Pronto para começar?\nEscolha um nome para o seu personagem:");
        
        //Define o nome do personagem
        Scanner scanner = new Scanner(System.in);
        String nome_personagem = scanner.nextLine(); //lê o que foi digitado pelo usuário
        heroi.setNome(nome_personagem); //atribuí o novo nome ao personagem

        combate.fluxoCombate();
        scanner.close();
    }
}
