
public class App {

    /**
    *Função main, a primeira a ser chamada que permite o código rodar
    *@throws InterruptedException Para controle de tempo da interface
    */
    public static void main(String[] args) throws InterruptedException{
        
        //Pré definições
        Heroi heroi = new Heroi("Calouro", 30, 0, 4, 3, 30);
        Inimigo inimigo = new Inimigo("MC102", 25, 0, 25);

        Tabuleiro tabuleiro = new Tabuleiro(heroi, inimigo); 
        Combate combate = new Combate(heroi, inimigo, tabuleiro); 
        tabuleiro.iniciarPartida(); 
        combate.fluxoCombate();
    }
}
