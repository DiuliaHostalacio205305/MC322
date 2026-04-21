package ic.lógica;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.organização.Cores;

public class Batalha {
    
    private Inimigo inimigoAtual;
    private List<Batalha> proximasBatalhas;

    public Batalha(Inimigo inimigoAtual){
        this.inimigoAtual = inimigoAtual;
        this.proximasBatalhas = new ArrayList<>();
    }

    public void adicionarNo(Batalha proxBatalha){
        this.proximasBatalhas.add(proxBatalha);
    }

    public void iniciar(Heroi heroi, Scanner scanner, Tabuleiro tabuleiro) throws InterruptedException{
        System.out.println(Cores.COLOR_YELLOW + "\n--- NOVA BATALHA ---\n");
        System.out.println("Seu próximo inimigo será: " + this.inimigoAtual.getName() + Cores.COLOR_RESET);

        //Começa o novo combate
        Combate novoCombate = new Combate(heroi, this.inimigoAtual, tabuleiro, scanner);
        novoCombate.fluxoCombate();
        //após a batalha, verifica se o herói ainda está vivo
        if(heroi.getVida() > 0 && heroi.getVida() < 8){
            System.out.println("Ufa... Você ficou de exame, mas passou em " + inimigoAtual.getName() + "! Se prepare pras próximas estudando nas férias...");
        } else if (heroi.getVida() >= 8){
            System.out.println(Cores.COLOR_YELLOW + "Parabéns! Você passou e foi aprovado com louvor, essa foi fácil pra você né?" + Cores.COLOR_RESET);
        } else {
            System.out.println("Ah... você reprovou, não foi dessa vez... Mas pode tentar pegar a matéria de novo e estude mais na próxima!");
            return; //encerra o jogo
        }

        //Se não tiver nenhum próximo nó disponível
        if(this.proximasBatalhas.isEmpty()){
            System.out.println("        ,,,,,,,,,,,,,\n" + //
                                "    .;;;;;;;;;;;;;;;;;;;,.\n" + //
                                "  .;;;;;;;;;;;;;;;;;;;;;;;;,\n" + //
                                ".;;;;;;;;;;;;;;;;;;;;;;;;;;;;.\n" + //
                                ";;;;;@;;;;;;;;;;;;;;;;;;;;;;;;' .............\n" + //
                                ";;;;@@;;;;;;;;;;;;;;;;;;;;;;;;'.................\n" + //
                                ";;;;@@;;;;;;;;;;;;;;;;;;;;;;;;'...................\n" + //
                                "`;;;;@;;;;;;;;;;;;;;;@;;;;;;;'.....................\n" + //
                                " `;;;;;;;;;;;;;;;;;;;@@;;;;;'..................;....\n" + //
                                "   `;;;;;;;;;;;;;;;;@@;;;;'....................;;...\n" + //
                                "     `;;;;;;;;;;;;;@;;;;'...;.................;;....\n" + //
                                "        `;;;;;;;;;;;;'   ...;;...............;.....\n" + //
                                "           `;;;;;;'        ...;;..................\n" + //
                                "              ;;              ..;...............\n" + //
                                "              `                  ............\n" + //
                                "             `                      ......\n" + //
                                "            `                         ..\n" + //
                                "           `                           '\n" + //
                                "          `                           '\n" + //
                                "         `                           '\n" + //
                                "        `                           `\n" + //
                                "        `                           `,\n" + //
                                "        `\n" + //
                                "         `\n" + //
                                "           `.");
            System.out.println(Cores.COLOR_GREEN + "UAU! PARABÉNS!\nApós muita luta e muitos desafios, você conseguiu graduar! Você acha que melhora? haha... Seja feliz no mercado de trabalho!" + Cores.COLOR_RESET);
            System.exit(0);
        }
    //Se o jogador não tiver chegado no fim do jogo
    System.out.println(Cores.COLOR_CYAN + "Escolha sua próxima batalha com sabedoria... e se a DAC deixar");
    System.out.println();
    for(int i = 0; i < this.proximasBatalhas.size(); i++){ //percorre a lista das próximas batalhas (que contém os nós filhos)
        System.out.println((i + 1) + " - " + this.proximasBatalhas.get(i).inimigoAtual.getName());
    }
    System.out.println(Cores.COLOR_RESET + "\nDigite o número da sua escolha:");
    int escolha = scanner.nextInt();
    Batalha prox = this.proximasBatalhas.get(escolha - 1);
    heroi.setCafeina(4);
    heroi.resetaEscudo();
    heroi.limpaEfeitos();
    tabuleiro.limparMao();

    prox.iniciar(heroi, scanner, tabuleiro); //chama a próxima batalha escolhida pelo jogador
    }
}