package ic.inimigos;

import ic.cartas.CartaBurnout;
import ic.cartas.CartaDano;
import ic.cartas.CartaEscudo;
import ic.cartas.CartaLockin;
import ic.entidades.Entidade;
import ic.entidades.Heroi;
import ic.entidades.Inimigo;
import ic.lógica.Combate;
import ic.lógica.Tabuleiro;
import ic.organização.Cores;

public class Mc322 extends Inimigo {
    
    public Mc322(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo, vidaMax);
    }

    @Override
    public void falaRodada1(Heroi heroi){
                System.out.println(Cores.COLOR_PURPLE + "\nOlha como vocês crescem... já são veteranos agora \\ (^_^) /" + Cores.COLOR_RESET); 
        System.out.println(Cores.COLOR_CYAN + "Vamos começar a batalha!\nNessa próxima fase, seu oponente será o \n");
        System.out.println("+==============================+\n" + //
                        "| __  __  ___  ___  ___   ___  |\n" + //
                        "|(  \\/  )/ __)(__ )(__ \\ (__ \\ |\n" + //
                        "| )    (( (__  (_ \\ / _/  / _/ |\n" + //
                        "|(_/\\/\\_)\\___)(___/(____)(____)|\n" + //
                        "+==============================+" + Cores.COLOR_RESET);
        System.out.println(Cores.COLOR_RED + "\n- MC322: 'Agora nem preciso mais pegar leve com vocês. Se prepare " + heroi.getName() + ". Não vai ser simples não... Tô aqui pra terminar o que 202 começou (te enlouquecer :)" + Cores.COLOR_RESET);
    }

    @Override
    public void imprimeAcaoInimigo(int acao){
        System.out.println("\n");
        if(acao == 0){
            System.out.println(Cores.COLOR_RED + "- MC322: 'Vou te fazer usar o gradle e você vai tomar 6 de dano ein, abre o olho'" + Cores.COLOR_RESET);
        }
        if(acao == 1){
            System.out.println(Cores.COLOR_RED + "- MC322: 'Vou te fazer tentar entender polimorfismo e encapsulamento ao mesmo tempo e te deixar com 4 pontos de burnout ein'" + Cores.COLOR_RESET);
        }
        if(acao == 2){
            System.out.println(Cores.COLOR_RED + "- MC322: 'Vou me deixar de Lock-In, com 3 pontos a mais de força, ein'" + Cores.COLOR_RESET);
        }
        if(acao == 3){
            System.out.println(Cores.COLOR_RED+  "- MC322: 'Vou me dar 3 de escudo, ein'" + Cores.COLOR_RESET);
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
            CartaDano ataque = new CartaDano("Instalar o gradle", "Você agora precisa utilizar o gradle, mas o GitHub ignora algumas pastas quando você vai dar pull e seu computador não aguenta rodar o gradle", 0, 6);
            heroi.receberDano(ataque.getDano() + combate.getInimigo().getLockin()); //o dano que o herói recebe é o dano da carta + o lockin acumulado
            System.out.println(Cores.COLOR_RED + "O inimigo está te atacando com 'usar Gradle'");
            System.out.println( "··································································\n" + //
                                ":   _____    ______       ____     ______     _____        _____ :\n" + //
                                ":  / ___ \\  (   __ \\     (    )   (_  __ \\   (_   _)      / ___/ :\n" + //
                                ": / /   \\_)  ) (__) )    / /\\ \\     ) ) \\ \\    | |       ( (__   :\n" + //
                                ":( (  ____  (    __/    ( (__) )   ( (   ) )   | |        ) __)  :\n" + //
                                ":( ( (__  )  ) \\ \\  _    )    (     ) )  ) )   | |   __  ( (     :\n" + //
                                ": \\ \\__/ /  ( ( \\ \\_))  /  /\\  \\   / /__/ /  __| |___) )  \\ \\___ :\n" + //
                                ":  \\____/    )_) \\__/  /__(  )__\\ (______/   \\________/    \\____\\:\n" + //
                                "··································································");
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
            CartaBurnout burnout = new CartaBurnout("Entender polimorfismo e encapsulamento ao mesmo tempo", "Você vai ficar boas horas tentando entender e adivinha? Não vai conseguir...", 0, 4, heroi);
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
            System.out.println("Nova força do inimigo:" + (getLockin() + 3) + "\nAgora os ataques do inimigo darão 3 a mais de dano" + Cores.COLOR_RESET);
            CartaLockin Lockin = new CartaLockin("Não pode usar GitHub", "A partir de agora o inimigo te proíbe de usar o GitHub e você precisa copiar e colar cada pasta da sua dupla", 0, 3, combate.getInimigo());
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
            CartaEscudo escudo = new CartaEscudo("Muitos arquivos", "O inimigo mistura todas as suas pastas no VsCode e você precisa desembaralhar todas elas", 0, 3);
            combate.getInimigo().ganharEscudo(escudo.getEscudo());
        }
    }
}
