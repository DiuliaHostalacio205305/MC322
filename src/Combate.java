import java.util.ArrayList;
import java.util.List;


public class Combate {

    private Heroi heroi;
    private Inimigo inimigo;
    private List<Efeito> subscribers = new ArrayList<>();

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
}
