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
import ic.organização.Prints;

/**
 * Classe que herda de Inimigo {@link Inimigo} e cria uma espécie de inimigo mais específica, MC202
 */
public class Mc202 extends Inimigo {
    
    /**
     * Construtor da classe Mc202, um tipo de inimigo do jogo que herda de Inimigo {@link Inimigo}
     * @param nome O nome do inimigo
     * @param vida A vida atual do inimigo
     * @param escudo O escudo atual do inimigo
     * @param vidaMax A vida máxima, e inicial, do inimigo
     */
    public Mc202(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo, vidaMax);
    }

    /**
     * Permite que cada inimigo tenha uma fala personalizada no começo da rodada 
     * @param heroi O herói do jogo que poderá sofrer uma ação do inimigo
     */
    @Override
    public void falaRodada1(Heroi heroi){
        System.out.println(Cores.COLOR_PURPLE + "\nOlha... Parabéns, agora você não é mais bixo... já pode ser chamado de projeto de programador! Falta muito ainda pra realmente ser um programador... mas tudo bem, podemos começar o próximo desafio " + heroi.getName() + "? Eu me prepararia se fosse você..." + Cores.COLOR_RESET); 
        System.out.println(Cores.COLOR_CYAN + "ENtão, vamos começar a batalha!\nNessa segunda fase, seu oponente será o \n");
        System.out.println(Prints.MC202);
        System.out.println(Cores.COLOR_RED + "\n- MC202: 'Coitado, lá vem um que acha que já sabe programar achando que vai ser fácil passar por mim HAHAHAHA (risada maléfica)'" + Cores.COLOR_RESET);
    }

    /**
     * Imprime a ação do inimigo calculada pela intenção, que permite avisar ao jogador a intenção do inimigo no começo da rodada
     * @param acao
     */
    @Override
    public void imprimeAcaoInimigo(int acao){
        System.out.println("\n");
        if(acao == 0){
            System.out.println(Cores.COLOR_RED + "- MC202: 'Você vai ter um erro de compilação e vai tomar 7 de dano ein'" + Cores.COLOR_RESET);
        }
        if(acao == 1){
            System.out.println(Cores.COLOR_RED + "- MC202: 'Vou te deixar 15 horas debugando um erro na estrutura de uma árvore rubro negra e e te deixar com 6 pontos de burnout ein'" + Cores.COLOR_RESET);
        }
        if(acao == 2){
            System.out.println(Cores.COLOR_RED + "- MC202: 'Vou me deixar de Lock-In, com 4 pontos a mais de força, ein'" + Cores.COLOR_RESET);
        }
        if(acao == 3){
            System.out.println(Cores.COLOR_RED+  "- MC202: 'Vou me dar 3 de escudo, fica esperto'" + Cores.COLOR_RESET);
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
            CartaDano ataque = new CartaDano("Erro de compilação", "Seu maior código já feito tem um erro de compilação que nem o valgrind sabe dizer onde é...", 0, 7);
            heroi.receberDano(ataque.getDano() + combate.getInimigo().getLockin()); //o dano que o herói recebe é o dano da carta + o lockin acumulado
            System.out.println(Cores.COLOR_RED + "O inimigo está te atacando com um 'Erro de compilação'");
            System.out.println(Prints.TIME_LIMIT);
            System.out.println("Dano recebido: " + (ataque.getDano() + combate.getInimigo().getLockin()) + Cores.COLOR_RESET);
            //assim n vai dar pra ele avisar o dano e tudo 
        }
        if(acao == 1){
            System.out.println(Cores.COLOR_ORANGE + "\nO inimigo está usando burnout em você");
            System.out.println(Prints.BURNOUT);
            System.out.println("Você recebeu o efeito 'burnout' com acúmulo por + 6 rodadas" + Cores.COLOR_RESET);
            CartaBurnout burnout = new CartaBurnout("Debugando um erro por 15 horas", "Você precisou implementar uma árvore rubro negra no seu código e ela está com um erro que você não consegue achar", 0, 6, heroi);
            burnout.usar(tabuleiro, combate);
        }
        if(acao == 2){
            System.out.println(Cores.COLOR_ORANGE + "\nO inimigo está usando força em si mesmo");
            System.out.println(Prints.LOCKIN);
            System.out.println("Nova força do inimigo: " + (getLockin() + 4) + "\nAgora os ataques do inimigo darão + " + (getLockin() + 4) + "de dano" + Cores.COLOR_RESET);
            CartaLockin Lockin = new CartaLockin("Codar em papel", "A partir de agora o inimigo te permite codar apenas no papel (e se não compilar, leva um zero na questão da prova)", 0, 4, combate.getInimigo());
            Lockin.usar(tabuleiro, combate);
        }
        if(acao == 3){
            System.out.println(Cores.COLOR_RED + "O inimigo está usando escudo em si mesmo");
            System.out.println(Prints.ESCUDO);
            System.out.println("Novo escudo do inimigo: 4/4" + Cores.COLOR_RESET);
            CartaEscudo escudo = new CartaEscudo("Arquivo zip", "O inimigo coloca o READ_ME que você precisava pra entender a tarefa em um arquivo .ZIP pra você não conseguir abrir", 0, 3);
            combate.getInimigo().ganharEscudo(escudo.getEscudo());
        }
    }
}
