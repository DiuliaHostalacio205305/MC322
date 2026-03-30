/*
- Atributos: nome, vida, escudo
- Métodos: receberDano, atacar, estaVivo */
import java.util.Random;

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


    private int intencao; //o ataque do inimigo vai ficar salvo aqui
    int vidaMax;

    public Inimigo(String nome, int vida, int escudo, int vidaMax){
        super(nome, vida, escudo);
        this.vidaMax = vidaMax; 
    }

    public int getvidaMax(){
        return vidaMax;
    }

    public int getIntencao(){
        return intencao;
    }

    public void randomizarAtaque(){
        Random random = new Random();
        this.intencao = random.nextInt(3);
    }

    public void atacar(Entidade heroi, Combate combate, Tabuleiro tabuleiro){
        int acao = this.intencao;

        if(acao == 0){
            CartaDano ataque = new CartaDano("Time limit", "Você caiu em um time limit com um for dentro de um for...", 0, 5);
            ataque.usar(tabuleiro, combate);
            System.out.println("O inimigo está atacando");
            //assim n vai dar pra ele avisar o dano e tudo 
        }
        if(acao == 1){
            System.out.println("O inimigo está usando veneno");
            CartaBurnout burnout = new CartaBurnout("Burnout inimigo", "descrição burnout do inimigo", 0, 4, heroi);
            burnout.usar(tabuleiro, combate);
        }
        if(acao == 2){
            System.out.println("O inimigo está usando força em si mesmo");
            CartaLockin Lockin = new CartaLockin("nome força", "descrição força", 0, 3);
            Lockin.usar(tabuleiro, combate);
        }
        if(acao == 3){
            System.out.println("O inimigo está usando escudo em si mesmo");
            CartaEscudo escudo = new CartaEscudo("nome escudo", "descrição escudo", 0, 3);
            escudo.usar(tabuleiro, combate);
        }
    }

    public void imprimeAcaoInimigo(int acao){
        if(acao == 0){
            System.out.println(COLOR_RED + "-MC102: 'Você vai cair em um time limit e vai tomar 5 de dano ein'" + COLOR_RESET);
        }
        if(acao == 1){
            System.out.println(COLOR_RED + "-MC102: 'Vou botar um Lab na mesma semana de 3 provas e te deixar com 4 pontos de burnout ein'" + COLOR_RESET);
        }
        if(acao == 2){
            System.out.println(COLOR_RED + "-MC102: 'Vou me deixar de Lock-In, com 3 pontos a mais de força, ein'" + COLOR_RESET);
        }
        if(acao == 3){
            System.out.println(COLOR_RED+  "-MC102: 'Vou me dar 3 de escudo, ein'" + COLOR_RESET);
        }
    }
}


//Ideias de nomes de ataques: erro de compilação, esqueceu o ;, deu time limit, caiu num loop infinito