import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("--- NOVA BATALHA ---\n");
        System.out.println("Seu próximo inimigo será: " + this.inimigoAtual.getName());

        //Começa o novo combate
        Combate novoCombate = new Combate(heroi, this.inimigoAtual, tabuleiro);
        novoCombate.fluxoCombate();
        //após a batalha, verifica se o herói ainda está vivo
        if(heroi.getVida() > 0 && heroi.getVida() < 8){
            System.out.println("Ufa... Você ficou de exame, mas passou em " + inimigoAtual.getName() + "! Se prepare pras próximas estudando nas férias...");
        } else if (heroi.getVida() >= 8){
            System.out.println("Parabéns! Você passou e foi aprovado com louvor, essa foi fácil pra você né?");
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
            System.out.println("UAU! PARABÉNS!\nApós muita luta e muitos desafios, você conseguiu graduar! Você acha que melhora? haha... Seja feliz no mercado de trabalho!");
        }
    }
}
