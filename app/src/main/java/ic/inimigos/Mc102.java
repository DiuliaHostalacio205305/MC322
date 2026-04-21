package ic.inimigos;

import ic.cartas.CartaBurnout;
import ic.cartas.CartaDano;
import ic.cartas.CartaEscudo;
import ic.cartas.CartaLockin;
import ic.entidades.Entidade;
import ic.entidades.Heroi;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;
import ic.organização.Cores;

public class Mc102 extends Inimigo {

    public Mc102(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo, vidaMax);
    }

    @Override
    public void falaRodada1(Heroi heroi){
                System.out.println(Cores.COLOR_PURPLE + "\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + heroi.getName() + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n" + Cores.COLOR_RESET); 
        System.out.println(Cores.COLOR_CYAN + "Vamos começar a batalha!\nNessa primeira fase, seu oponente será o \n");
        System.out.println("╔════════════════════════════════════════════╗\r\n" + //
                                        "║ ███╗   ███╗ ██████╗ ██╗ ██████╗ ██████╗    ║\r\n" + //
                                        "║ ████╗ ████║██╔════╝███║██╔═████╗╚════██╗   ║\r\n" + //
                                        "║ ██╔████╔██║██║     ╚██║██║██╔██║ █████╔╝   ║\r\n" + //
                                        "║ ██║╚██╔╝██║██║      ██║████╔╝██║██╔═══╝    ║\r\n" + //
                                        "║ ██║ ╚═╝ ██║╚██████╗ ██║╚██████╔╝███████╗   ║\r\n" + //
                                        "║ ╚═╝     ╚═╝ ╚═════╝ ╚═╝ ╚═════╝ ╚══════╝   ║\r\n" + //
                                        "╚════════════════════════════════════════════╝" + Cores.COLOR_RESET);
        System.out.println(Cores.COLOR_RED + "\n- MC102: 'Argh, mais um bixo pra lutar contra mim?! Vocês não cansam de sofrer com Python não?'" + Cores.COLOR_RESET);
    }

    @Override
    public void imprimeAcaoInimigo(int acao){
        //System.out.println("\n");
        if(acao == 0){
            System.out.println(Cores.COLOR_RED + "- MC102: 'Você vai cair em um time limit e vai tomar 5 de dano ein'" + Cores.COLOR_RESET);
        }
        if(acao == 1){
            System.out.println(Cores.COLOR_RED + "- MC102: 'Vou botar um Lab na mesma semana de 3 provas e te deixar com 4 pontos de burnout ein'" + Cores.COLOR_RESET);
        }
        if(acao == 2){
            System.out.println(Cores.COLOR_RED + "- MC102: 'Vou me deixar de Lock-In, com 3 pontos a mais de força, ein'" + Cores.COLOR_RESET);
        }
        if(acao == 3){
            System.out.println(Cores.COLOR_RED+  "- MC102: 'Vou me dar 3 de escudo, ein'" + Cores.COLOR_RESET);
        }
    }

    /**
     * Controla o ataque do inimigo durante o turno, a partir da intenção randomizada anteriormente
     * @param heroi O herói do jogo que poderá sofrer uma ação do inimigo 
     * @param combate Classe que controla o fluxo do jogo.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     */
    @Override
    public void atacar(Entidade heroi, Combate combate, Tabuleiro tabuleiro){
        int acao = this.intencao;

        if(acao == 0){
            CartaDano ataque = new CartaDano("Time limit", "Você caiu em um time limit com um for dentro de um for...", 0, 5);
            heroi.receberDano(ataque.getDano() + combate.getInimigo().getLockin()); //o dano que o herói recebe é o dano da carta + o lockin acumulado
            System.out.println(Cores.COLOR_RED + "O inimigo está te atacando com um time limit");
            System.out.println( "       .-.-.\r\n" + //
                                "  ((  (__I__)  ))\r\n" + //
                                "    .'_....._'.\r\n" + //
                                "   / / .12 . \\ \\\r\n" + //
                                "  | | '  |  ' | |\r\n" + //
                                "  | | 9  /  3 | |\r\n" + //
                                "   \\ \\ '.6.' / /\r\n" + //
                                "    '.`-...-'.'\r\n" + //
                                "     /'-- --'\\\r\n" + //
                                "    `\"\"\"\"\"\"\"\"\"`\r\n" + //
                                "");
            System.out.println("Dano recebido: " + (ataque.getDano() + combate.getInimigo().getLockin()) + Cores.COLOR_RESET);
            //assim n vai dar pra ele avisar o dano e tudo 
        }
        if(acao == 1){
            System.out.println(Cores.COLOR_ORANGE + "\nO inimigo está usando burnout em você");
            System.out.println("⠀⠀⠀⠀⠀⠀⢱⣆⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠈⣿⣷⡀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣷⣧⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⡀⢠⣿⡟⣿⣿⣿⡇⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⣳⣼⣿⡏⢸⣿⣿⣿⢀⠀\r\n" + //
                                "⠀⠀⠀⣰⣿⣿⡿⠁⢸⣿⣿⡟⣼⡆\r\n" + //
                                "⢰⢀⣾⣿⣿⠟⠀⠀⣾⢿⣿⣿⣿⣿\r\n" + //
                                "⢸⣿⣿⣿⡏⠀⠀⠀⠃⠸⣿⣿⣿⡿\r\n" + //
                                "⢳⣿⣿⣿⠀⠀⠀⠀⠀⠀⢹⣿⡿⡁\r\n" + //
                                "⠀⠹⣿⣿⡄⠀⠀⠀⠀⠀⢠⣿⡞⠁\r\n" + //
                                "⠀⠀⠈⠛⢿⣄⠀⠀⠀⣠⠞⠋⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀");
            System.out.println("Você recebeu o efeito 'burnout' com acúmulo por + 4 rodadas" + Cores.COLOR_RESET);
            CartaBurnout burnout = new CartaBurnout("Lab na mesma semana que 3 provas", "Você vai ter uma semana com mais obrigações do que horas no dia", 0, 4, heroi);
            burnout.usar(tabuleiro, combate);
        }
        if(acao == 2){
            System.out.println(Cores.COLOR_ORANGE + "\nO inimigo está usando força  em si mesmo");
            System.out.println("   ┌──────────────┐                          ┌─────────────┐   \r\n" + //
                                "   │██████████████│                          │█████████████│   \r\n" + //
                                "┌──┐██████████████│                          │█████████████┌──┐\r\n" + //
                                "│██│██████████████│══════════════════════════│█████████████│██│\r\n" + //
                                "│██│██████████████│══════════════════════════│█████████████│██│\r\n" + //
                                "└──┘██████████████│                          │█████████████└──┘\r\n" + //
                                "   │██████████████│                          │█████████████│   \r\n" + //
                                "   └──────────────┘                          └─────────────┘   ");
            System.out.println("Nova força do inimigo: 3\nAgora os ataques do inimigo darão + 3 de dano" + Cores.COLOR_RESET);
            CartaLockin Lockin = new CartaLockin("Codar em papel", "A partir de agora o inimigo te permite codar apenas no papel", 0, 3, combate.getInimigo());
            Lockin.usar(tabuleiro, combate);
        }
        if(acao == 3){
            System.out.println(Cores.COLOR_RED + "O inimigo está usando escudo em si mesmo");
            System.out.println( "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⣿⣿⣷⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⣤⣤⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣶⣤⣤⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣿⣿⣿⣿⣿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n" + //
                                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
            System.out.println("Novo escudo do inimigo: 3/3" + Cores.COLOR_RESET);
            CartaEscudo escudo = new CartaEscudo("Arquivo zip", "O inimigo coloca o READ_ME que você precisava pra entender a tarefa em um arquivo .ZIP pra você não conseguir abrir", 0, 3);
            combate.getInimigo().ganharEscudo(escudo.getEscudo());
        }
    }
}
