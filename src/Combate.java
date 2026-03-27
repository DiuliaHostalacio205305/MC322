import java.util.ArrayList;
import java.util.List;


public class Combate {

    private Heroi heroi;
    private Inimigo inimigo;
    private List<Efeito> subscribers = new ArrayList<>();

    //código de cores
    public static final String COLOR_RESET = "\u001B[0m";
    public static final String COLOR_PURPLE = "\u001B[35m";
    public static final String COLOR_CYAN = "\u001B[36m";
    public static final String COLOR_RED = "\u001B[31m";
    public static final String COLOR_GREEN = "\u001B[32m";
    public static final String COLOR_YELLOW = "\u001B[33m";
    public static final String COLOR_LIGHT_GREEN = "\u001B[92m";
    public static final String COLOR_ORANGE = "\u001B[38;5;208m";
    public static final String COLOR_PINK = "\u001B[95m";


    public Combate(Heroi heroi, Inimigo inimigo){
        this.heroi = heroi;
        this.inimigo = inimigo;
    }

    public void subscribe(Efeito efeito){
        if(!subscribers.contains(efeito)){
            subscribers.add(efeito);
        }
    }

    public void unsubscribe(Efeito efeito){
        subscribers.remove(efeito);
    }

    public void notify(Evento evento){
        List<Efeito> copiaLista = new ArrayList<>(subscribers);
        for(int i = 0; i < copiaLista.size(); i++){
            Efeito e = copiaLista.get(i);
            e.serNotificado(evento, this);
        }
    }

    public void fluxoCombate() throws InterruptedException{
        System.out.println("Uma nova rodada está iniciando!\nÉ a sua vez de jogar!");
        //Turno do herói
        printaStats(heroi, inimigo);
        

    }

    public Entidade getHeroi(){
        return heroi;
    }

    public Entidade getInimigo(){
        return inimigo;
    }

    public static void printaStats(Heroi heroi, Inimigo inimigo) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println(COLOR_GREEN + "\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "/3" + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n" + COLOR_RESET);
        System.out.println(COLOR_RED + "--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo() + "\n" + COLOR_RESET);
    }
}
