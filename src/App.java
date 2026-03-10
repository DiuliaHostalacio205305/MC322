import java.util.Scanner;

public class App {

    //Definidores de cor
    public static final String colorReset = "\u001B[0m";
    public static final String colorPurple = "\u001B[35m";
    public static final String colorCyan = "\u001B[36m";
    public static final String colorRed = "\u001B[31m";
    public static final String colorGreen = "\u001B[32m";
    public static final String colorYellow = "\u001B[33m";
    public static final String colorLightGreen = "\u001B[92m";
    public static final String colorOrange = "\u001B[38;5;208m";
    public static final String colorPink = "\u001B[95m";

    public static void main(String[] args) throws InterruptedException{
        
        //Pré definições
        Heroi heroi = new Heroi("Calouro", 40, 0, 3);
        Inimigo inimigo = new Inimigo("MC102", 20, 0);
        int hpInimigo = inimigo.getVida();
        int hpHeroi = heroi.getVida();
        CartaDano cartaDano = new CartaDano("ataque", 1, 3);
        CartaEscudo cartaEscudo = new CartaEscudo("escudo", 1, 2);
        int acao = 0;

        //Texto de inicialização
        System.out.println("Olá! Seja bem-vindo ao curso de Computação da Unicamp! \nPara graduar você precisará passar por diversos desafios, bosses, irritações, surtos... Hm, quer dizer, adversários ótimos que te fortalecerão nessa aventura!");
        System.out.println("Hoje, você pode até estar começando como um jovem e ingênuo programador de Python, ou apenas entusiasta da programação... mas não se preocupe, logo você perceberá que nem tudo é tão fácil quanto Python parece ser\n");
        System.out.println("Cada batalha será um passo em direção ao seu sonho de se tornar um Desenvolvedor Sênior, e cada inimigo que derrotar te deixará mais perto desse objetivo (e um pouco mais doido também)\n");
        System.out.println("Durante os combates, você começa atacando, e pode escolher entre:\n1 - Atacar\n2 - Utilizar um escudo\n3 - Encerrar seu turno\n\nLembrando que cada ação gastará uma certa quantidade da sua cafeína total, o cafézinho que você toma do IC... então gaste com sabedoria, porque nem sempre a máquina de café funciona...\n");
        System.out.println("Pronto para começar?\nEscolha um nome para o seu personagem:");
        
        //Define o nome do personagem
        Scanner scanner = new Scanner(System.in);
        String nome_personagem = scanner.nextLine(); //lê o que foi digitado pelo usuário
        heroi.setNome(nome_personagem); //atribuí o novo nome ao personagem

        /*PRIMEIRA RODADA*/
        System.out.println(colorPurple + "\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + nome_personagem + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n" + colorReset); 
        System.out.println(colorCyan + "Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n" + colorReset);
        Thread.sleep(3000);
        printaStats(heroi, inimigo);
        textoEscolha(heroi);
        acao = scanner.nextInt();
        escolhaAcoesHeroi(acao, heroi, inimigo, cartaDano, cartaEscudo, hpInimigo);

        /*RODADAS SEGUINTES*/
        while(heroi.estaVivo() && inimigo.estaVivo()){ //agora roda até um dos 2 morrer

            //Turno do heroí
            while (acao !=3 && heroi.getCafeina() != 0){
                System.err.println(colorGreen + "\nÉ sua vez novamente!" + colorReset);
                Thread.sleep(3500);
                printaStats(heroi, inimigo);
                textoEscolha(heroi);
                acao = scanner.nextInt();
                escolhaAcoesHeroi(acao, heroi, inimigo, cartaDano, cartaEscudo, hpInimigo);
                if (algmMorreu(inimigo, hpInimigo)){
                    break;
                }
            }

            //Turno do inimigo
            if(inimigo.getVida() > 0){ //o inimigo só ataca se estiver vivo
                System.out.println("\nAgora é a vez de " + inimigo.getName());
                System.out.println(colorRed + "Ele usou: (insira nome legal) e deu 5 de dano. Ouch!" + colorReset);
                inimigo.atacar(heroi); //colocar uma função random aq pra variar entre ataque e escudo pro inimigo
                if(heroi.getVida() <= 0){
                    System.out.println("Vida de " + heroi.getName() + " = 0/" + hpHeroi);
                    break;
                }
                System.out.println(colorGreen + "Vida de " + heroi.getName() + " = " + heroi.getVida() + "/" + hpHeroi + colorReset);
                Thread.sleep(3500);
                //DIU- tirei o negocio q tava repetitivo msm e mandei o é a sua vez pra cima
            }

            //Reseta a ação e a cafeína e o escudo
            acao = 0;
            heroi.setCafeina(3);
            heroi.resetaEscudo();
        }
    
        if(heroi.getVida() < 0){
            System.out.println("\nVocê reprovou :(");
        }                inimigo.atacar(heroi); //colocar uma função random aq pra variar entre ataque e escudo pro inimigo
        if(inimigo.getVida() < 0){
                System.out.println("\nVocê passou :)");
        }
        scanner.close();
    }


    /*FUNÇÕES UTÉIS PARA A ORGANIZAÇÃO*/
    
    //Verifica a quantidade de cafeína restante e printa o resultado
    public static void infosCafeina(Heroi heroi) throws InterruptedException{
        System.out.println(colorYellow + "Cafeína disponível: " + heroi.getCafeina() + colorReset);
        Thread.sleep(3500);
        if(heroi.getCafeina() == 0){
            System.out.println(colorRed + "\nAcabou sua cafeína :(" + colorReset);
        }
    }
    
    //Define o que acontece dependendo do número da ação escolhida pelo usuário
    public static void escolhaAcoesHeroi(int acao, Heroi heroi, Inimigo inimigo, CartaDano cartaDano, CartaEscudo cartaEscudo, int hpInimigo) throws InterruptedException{
        if(acao != 3){
            System.out.print(colorPurple + "\nÓtima escolha! Você escolheu: " + colorReset);
        }
            
       if(acao == 1){ //escolheu atacar
            System.out.println(cartaDano.getName() + ", uma carta de ataque!"); //colocar tipo o do personagem: nome, habilidade, descrição, etc pra ambientar o jogo
            cartaDano.usar(inimigo, heroi);
            
            System.out.println("\nVida de " + inimigo.getName() + " = " + inimigo.getVida() + "/" + hpInimigo);
            infosCafeina(heroi);
        }
        else if(acao == 2){ //escolheu usar escudo
            System.out.println(cartaEscudo.getName() + ", uma carta de escudo!");
            cartaEscudo.usar(heroi);
            System.out.println(colorCyan + "\nEscudo de " + heroi.getName() + " = " + heroi.getEscudo() + colorReset); //colocar um limite de escudo, tipo, escudomax = 3 e ai quando printar fazer 2/3
            infosCafeina(heroi);
        }
        else if(acao == 3){ //escolheu encerrar o turno
            System.out.println("Certeza?! Tá bom... Encerrando turno");
        }
        else { //o usuário (burro) não digitou nenhum dos 3
            System.out.println("Você não escolheu uma ação válida. Por favor, digite um número entre 1, 2, e 3 e aperte Enter");
        }
    }

    //Printa nome, vida e escudo tanto do herói, quanto do inimigo
    public static void printaStats(Heroi heroi, Inimigo inimigo){
        System.out.println(colorGreen + "\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n" + colorReset);
        System.out.println(colorRed + "--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo() + colorReset);
    }

    //Retorna true se o inimigo morreu
    public static boolean algmMorreu(Inimigo inimigo, int hpInimigo){
        if(inimigo.getVida() <= 0){
            System.out.println("\nVida de " + inimigo.getName() + " = 0/" + hpInimigo);
            return true;
        }
        return false;
    }

    //Printa as infos pro user saber qual número apertar
    public static void textoEscolha(Heroi heroi){
        System.out.println("\nEscolha uma ação:\n");
        System.out.println(colorLightGreen +"- 1: Usar Carta de Ataque -> Cafeína - 1");
        System.out.println(colorCyan +"- 2: Usar Carta de Escudo -> Cafeína - 1");
        System.out.println(colorRed + "- 3: Encerrar turno\n");
        System.out.println(colorYellow + "- Cafeína disponível: " + heroi.getCafeina() + colorReset+ "\n");
        System.out.println("Digite o número da ação escolhida:");
    }
}

//SOF - tem que levar em conta o escudo, pq se o héroi usa um escudo, e o bixo da 5 de dano, tira 5 da vida, ao inves de 2 do escudo e 3 da vida
//eu coloquei uns Thread.sleep(4000), é pro tempo entre os prints, tá em milisegundo (4000 = 4s), se quiser aumentar/diminuir, fica a  cu