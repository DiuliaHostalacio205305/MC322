import java.util.Scanner;

public class App {
    /**
    *Função main, a primeira a ser chamada que permite o código rodar
    *@throws InterruptedException Para controle de tempo da interface
    */
    public static void main(String[] args) throws InterruptedException{
        
        //abre o scanner
        Scanner scanner = new Scanner(System.in);

        //Chama quem gerencia o jogo e começa a campanha
        Gerenciador jogo = new Gerenciador();
        jogo.comecarJogo(scanner);

        //fecha o scanner
        scanner.close();
    }
}
