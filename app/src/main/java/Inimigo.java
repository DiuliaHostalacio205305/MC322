import java.util.Random;

/**
 *Classe que cria o inimigo do jogo.
 Herda de Entidade {@link Entidade}.
 */

public class Inimigo extends Entidade{

    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";


    private int intencao; //guarda qual será o ataque do Inimigo
    int vidaMax;

    /**
     * Construtor da classe Inimigo.
     * @param nome O nome que identifica o inimigo no jogo.
     * @param vida A quantidade de pontos de vida do inimigo.
     * @param escudo A quantidade de pontos de escudo do inimigo.
     */
    public Inimigo(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo);
        this.vidaMax = vidaMax; 
    }

    /**
     * Acessa e retorna a vida máxima que o inimigo pode ter.
     * @return A vida máxima do inimigo (int).
     */
    public int getvidaMax(){
        return vidaMax;
    }

    /**
     * Acessa e retorna o que o inimigo pretende realizar naquele turno (intenção).
     * @return A intenção do inimigo (int).
     */
    public int getIntencao(){
        return intencao;
    }

    /**
     * Sorteia a partir do random {@link Random} a ação do inimigo naquele turno
     */
    public void randomizarAtaque(){
        Random random = new Random();
        this.intencao = random.nextInt(4);
    }

    /**
     * Controla o ataque do inimigo durante o turno, a partir da intenção randomizada anteriormente
     * @param heroi O herói do jogo que poderá sofrer uma ação do inimigo 
     * @param combate Classe que controla o fluxo do jogo.
     * @param tabuleiro Classe que contém todas as "peças" do jogo, herói, inimigo e todas as cartas existentes.
     */
    public void atacar(Entidade heroi, Combate combate, Tabuleiro tabuleiro){
        int acao = this.intencao;

        if(acao == 0){
            CartaDano ataque = new CartaDano("Time limit", "Você caiu em um time limit com um for dentro de um for...", 0, 5);
            heroi.receberDano(ataque.getDano() + combate.getInimigo().getLockin()); //o dano que o herói recebe é o dano da carta + o lockin acumulado
            System.out.println(COLOR_RED + "O inimigo está te atacando com um time limit");
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
            System.out.println("Dano recebido: " + (ataque.getDano() + combate.getInimigo().getLockin()) + COLOR_RESET);
            //assim n vai dar pra ele avisar o dano e tudo 
        }
        if(acao == 1){
            System.out.println(COLOR_ORANGE + "\nO inimigo está usando burnout em você");
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
            System.out.println("Você recebeu o efeito 'burnout' com acúmulo por + 4 rodadas" + COLOR_RESET);
            CartaBurnout burnout = new CartaBurnout("Lab na mesma semana que 3 provas", "Você vai ter uma semana com mais obrigações do que horas no dia", 0, 4, heroi);
            burnout.usar(tabuleiro, combate);
        }
        if(acao == 2){
            System.out.println(COLOR_ORANGE + "\nO inimigo está usando força  em si mesmo");
            System.out.println("   ┌──────────────┐                          ┌─────────────┐   \r\n" + //
                                "   │██████████████│                          │█████████████│   \r\n" + //
                                "┌──┐██████████████│                          │█████████████┌──┐\r\n" + //
                                "│██│██████████████│══════════════════════════│█████████████│██│\r\n" + //
                                "│██│██████████████│══════════════════════════│█████████████│██│\r\n" + //
                                "└──┘██████████████│                          │█████████████└──┘\r\n" + //
                                "   │██████████████│                          │█████████████│   \r\n" + //
                                "   └──────────────┘                          └─────────────┘   ");
            System.out.println("Nova força do inimigo: 3\nAgora os ataques do inimigo darão + 3 de dano" + COLOR_RESET);
            CartaLockin Lockin = new CartaLockin("Codar em papel", "A partir de agora o inimigo te permite codar apenas no papel", 0, 3, combate.getInimigo());
            Lockin.usar(tabuleiro, combate);
        }
        if(acao == 3){
            System.out.println(COLOR_RED + "O inimigo está usando escudo em si mesmo");
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
            System.out.println("Novo escudo do inimigo: 3/3" + COLOR_RESET);
            CartaEscudo escudo = new CartaEscudo("Arquivo zip", "O inimigo coloca o READ_ME que você precisava pra entender a tarefa em um arquivo .ZIP pra você não conseguir abrir", 0, 3);
            combate.getInimigo().ganharEscudo(escudo.getEscudo());
        }
    }

    public void imprimeAcaoInimigo(int acao){
        System.out.println("\n");
        if(acao == 0){
            System.out.println(COLOR_RED + "- MC102: 'Você vai cair em um time limit e vai tomar 5 de dano ein'" + COLOR_RESET);
        }
        if(acao == 1){
            System.out.println(COLOR_RED + "- MC102: 'Vou botar um Lab na mesma semana de 3 provas e te deixar com 4 pontos de burnout ein'" + COLOR_RESET);
        }
        if(acao == 2){
            System.out.println(COLOR_RED + "- MC102: 'Vou me deixar de Lock-In, com 3 pontos a mais de força, ein'" + COLOR_RESET);
        }
        if(acao == 3){
            System.out.println(COLOR_RED+  "- MC102: 'Vou me dar 3 de escudo, ein'" + COLOR_RESET);
        }
    }
}