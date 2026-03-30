/*
- Atributos: nome, vida, escudo
- Métodos: receberDano, atacar, estaVivo */
import java.util.Random;

public class Inimigo extends Entidade{

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
            Random dadoDano = new Random();
            int dano = dadoDano.nextInt(5);
            CartaDano ataque = new CartaDano("Time limit", "Você caiu em um time limit com um for dentro de um for...", 0, dano);
            ataque.usar(tabuleiro, combate);
            System.out.println("O inimigo está atacando");
            //assim n vai dar pra ele avisar o dano e tudo 
        }
        if(acao == 1){
            System.out.println("O inimigo está usando veneno");
            Random dadoBurnout = new Random();
            int valorBurnout = dadoBurnout.nextInt(4);
            CartaBurnout burnout = new CartaBurnout("Burnout inimigo", "descrição burnout do inimigo", 0, valorBurnout, heroi);
            burnout.usar(tabuleiro, combate);
        }
        if(acao == 2){
            System.out.println("O inimigo está usando força em si mesmo");
            Random dadoLockin = new Random();
            int valorLockin = dadoLockin.nextInt(5);
            CartaLockin Lockin = new CartaLockin("nome força", "descrição força", 0, valorLockin);
            Lockin.usar(tabuleiro, combate);
        }
        if(acao == 3){
            System.out.println("O inimigo está usando escudo em si mesmo");
            Random dadoEscudo = new Random();
            int valorEscudo = dadoEscudo.nextInt(5);
            CartaEscudo escudo = new CartaEscudo("nome escudo", "descrição escudo", 0, valorEscudo);
            escudo.usar(tabuleiro, combate);
        }
    }

    public void imprimeAcaoInimigo(int acao){
        if(acao == 0){
            System.out.println("Você vai cair em um time limit e vai tomar x de dano ein");
        }
        if(acao == 1){
            System.out.println("Vou botar um Lab na mesma semana de 3 provas e te deixar de burnout ein");
        }
        if(acao == 2){
            System.out.println("Vou me deixar de Lock-In ein");
        }
        if(acao == 3){
            System.out.println("Vou usar escudo ein");
        }
    }
}


//Ideias de nomes de ataques: erro de compilação, esqueceu o ;, deu time limit, caiu num loop infinito