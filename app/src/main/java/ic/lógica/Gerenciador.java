package ic.lógica;
import java.util.Scanner;

import ic.entidades.Heroi;
import ic.inimigos.Mc102;
import ic.inimigos.Mc202;
import ic.inimigos.Mc322;
import ic.inimigos.Mc358;
import ic.inimigos.Mc404;
import ic.inimigos.Mc458;
import ic.inimigos.Mc558;
import ic.organização.Cores;

/**
 * Classe que gerencia a criação de objetos que serão utilizados no jogo
 */
public class Gerenciador {
    
    /**
     * Método que permite a pré inicialização do jogo, chamada na main(), cria todos os personagens, cartas, e nós, estruturando também a árvore usada como mapa
     * @param scanner O scanner que lê as entradas do terminal
     * @throws InterruptedException
     */
    public void comecarJogo(Scanner scanner) throws InterruptedException{

        //Pré-definições
        Heroi heroi = new Heroi("Calouro", 30, 0, 4, 3, 30);
        Tabuleiro tabuleiro = new Tabuleiro(heroi); //é o baralho de cartas e personagens
        
        //Pré definições da árvore mapa
        //Nível 1
        Batalha raiz = new Batalha(new Mc102("MC102", 25, 0, 25));
        //Nível 2
        Batalha no2 = new Batalha(new Mc202("MC202", 50, 1, 50));
        Batalha no3 = new Batalha(new Mc358("MC358", 35, 0, 35));
        //Nível 3
        Batalha no4 = new Batalha(new Mc322("MC322", 30, 0, 30));
        Batalha no5 = new Batalha(new Mc404("MC404", 35, 0, 35));
        Batalha no6 = new Batalha(new Mc458("MC458", 40, 0, 40));
        Batalha no7 = new Batalha(new Mc558("MC558", 42, 0, 42));
        
        //Cria a árvore do mapa e seus respectivos nós
        raiz.adicionarNo(no2);
        raiz.adicionarNo(no3);
        
        no2.adicionarNo(no4);
        no2.adicionarNo(no5);
        
        no3.adicionarNo(no6);
        no3.adicionarNo(no7);
        
        //Preenche e embaralha o deck de cartas
        tabuleiro.iniciarPartida();

        //Texto de inicialização
        System.out.println(Cores.COLOR_CYAN + "Olá! Seja bem-vindo ao curso de Computação da Unicamp!");
        System.out.println("Para graduar você precisará passar por diversos desafios, bosses, irritações, surtos... Hm, quer dizer, adversários ótimos que te fortalecerão nessa aventura!");
        System.out.println("Hoje, você pode até estar começando como um jovem e ingênuo programador de Python, ou apenas entusiasta da programação... mas não se preocupe, logo você perceberá que nem tudo é tão fácil quanto Python parece ser\n");
        System.out.println(Cores.COLOR_PURPLE + "Cada batalha será um passo em direção ao seu sonho de se tornar um Desenvolvedor Sênior, e cada inimigo que derrotar te deixará mais perto desse objetivo (e um pouco mais doido também)\n" + Cores.COLOR_RESET);
        System.out.println("Durante os combates, você começa atacando, e pode escolher entre:\n" + Cores.COLOR_LIGHT_GREEN + "- Carta de Ataque\n" + Cores.COLOR_CYAN + "- Carta de Efeito\n"  + Cores.COLOR_ORANGE + "- Carta de Escudo\n" + Cores.COLOR_RED + "- Encerrar seu turno\n\n" + Cores.COLOR_YELLOW + "Lembrando que cada ação gastará uma certa quantidade da sua cafeína total, o cafézinho que você toma do IC... então gaste com sabedoria, porque nem sempre a máquina de café funciona...\n" + Cores.COLOR_RESET);
        System.out.println("Pronto para começar?\nEscolha um nome para o seu personagem:");

        //Define o nome do personagem
        String nome_personagem = scanner.nextLine(); //lê o que foi digitado pelo usuário
        heroi.setNome(nome_personagem); //atribuí o novo nome ao personagem

        //Inicia o jogo no primeiro nó da árvore
        raiz.iniciar(heroi, scanner, tabuleiro);
    }
}
