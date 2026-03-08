import java.util.Scanner;

public class App {
    public static void main(String[] args) throws InterruptedException{
        Heroi heroi = new Heroi("Calouro", 40, 0, 3);
        Inimigo inimigo = new Inimigo("MC102", 20, 0);
        int hpInimigo = inimigo.getVida();
        int hpHeroi = heroi.getVida();
        System.out.println("Olá! Seja bem-vindo ao curso de Computação da Unicamp! \nPara graduar você precisará passar por diversos desafios, bosses, irritações, surtos... Hm, quer dizer, adversários ótimos que te fortalecerão nessa aventura!");
        System.out.println("Hoje, você pode até estar começando como um jovem e ingênuo programador de Python, ou apenas entusiasta da programação... mas não se preocupe, logo você perceberá que nem tudo é tão fácil quanto Python parece ser\n");
        System.out.println("Cada batalha será um passo em direção ao seu sonho de se tornar um Desenvolvedor Sênior, e cada inimigo que derrotar te deixará mais perto desse objetivo (e um pouco mais doido também)\n");
        System.out.println("Durante os combates, você começa atacando, e pode escolher entre:\n1 - Atacar\n2 - Utilizar um escudo\n3 - Encerrar seu turno\n\nLembrando que cada ação gastará uma certa quantidade da sua cafeína total, o cafézinho que você toma do IC... então gaste com sabedoria, porque nem sempre a máquina de café funciona...\n");
        System.out.println("Pronto para começar?\nEscolha um nome para o seu personagem:");
        
        Scanner scanner = new Scanner(System.in);
        String nome_personagem = scanner.nextLine(); //lê o que foi digitado pelo usuário
        System.out.println("\nÓtima escolha! Olá, bixo... quer dizer, Olá, " + nome_personagem + "!\nVocê iniciará esta campanha como Entusiasta de Programação!\n\n* Obs: Entusiasta de Programação é aquele que acha que tudo será fácil e lindo apenas porque ele gosta de computadores (doce ilusão) *\n"); 
        heroi.setNome(nome_personagem); //atribuí o novo nome ao personagem
        //eu acho que podia ter alguma interação aqui, pra n aparecer tudo de uma vez no terminal, tipo "Está pronto?", ou colocar o análogo de sleep aq em java q eu n sei como faz
        System.out.println("Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n");
        Thread.sleep(5000);

        CartaDano cartaDano = new CartaDano("ataque", 1, 3);
        CartaEscudo cartaEscudo = new CartaEscudo("escudo", 1, 2);
        int acao = 0;
        //colocar uma linha de print dentro de cada if dizendo qual foi a escolha
        
    

        while(heroi.estaVivo() && inimigo.estaVivo()){ //agora roda até um dos 2 morrer
        //a cada nova rodada que começa o heroi tem q ter o escudo zerado, então colocar uma linha aq pra zerar
            //colocar aqui um "while (cafeina != 0), pq quando acabar a energia ele tem q parar automático"
            //dentro desse while fazer o sistema de escolha de ação pro jogador e fora do segundo while (mas dentro do da linha 51) colocar o ataque do inimigo (com random? sla)
            //escrever algo genérico tipo "prox rodada" e printar a vida inicial dos dois
            
            //DIU - eu criei um loop pra rodada do jogador, talvez seja interessante tirar a primeira ação daqui de dentro  
            //SOF - acho que vai ter que tirar msm, até pra colocar uma escrita diferente
            
            //reseta a ação e a cafeína e o escudo
            acao = 0;
            heroi.setCafeina(3);
            heroi.resetaEscudo();

            while (acao !=3 && heroi.getCafeina() != 0){
                System.out.println("\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n");
                System.out.println("--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo());
                System.out.println("\nÉ o seu turno!");
                System.out.println("Preparado? Escolha uma ação:\n\n- 1: Usar Carta de Ataque -> Cafeína - 1\n- 2: Usar Carta de Escudo -> Cafeína - 1\n- 3: Encerrar turno\n\n- Cafeína disponível: " + heroi.getCafeina() + "\n");
                System.out.println("Digite o número da ação escolhida:");            
                acao = scanner.nextInt();
                if(acao != 3){
                    System.out.print("\nÓtima escolha! Você escolheu: ");
                }
            
                if(acao == 1){ //escolheu atacar
                    System.out.println(cartaDano.getName() + ", uma carta de ataque!"); //colocar tipo o do personagem: nome, habilidade, descrição, etc pra ambientar o jogo
                    cartaDano.usar(inimigo, heroi);
                    if(inimigo.getVida() <= 0){
                        System.out.println("\nVida de " + inimigo.getName() + " = 0/" + hpInimigo);
                        break; //mata o while pra consertar o problema dele atacar dps de morto 
                    }
                    System.out.println("\nVida de " + inimigo.getName() + " = " + inimigo.getVida() + "/" + hpInimigo);
                    System.out.println("Cafeína disponível: " + heroi.getCafeina());
                    Thread.sleep(3500);
                    if(heroi.getCafeina() == 0){
                        System.out.println("\nAcabou sua cafeína :(");
                    }
                }
                else if(acao == 2){ //escolheu usar escudo
                    System.out.println(cartaEscudo.getName() + ", uma carta de escudo!");
                    cartaEscudo.usar(heroi);
                    System.out.println("\nEscudo de " + heroi.getName() + " = " + heroi.getEscudo()); //colocar um limite de escudo, tipo, escudomax = 3 e ai quando printar fazer 2/3
                    System.out.println("Cafeína disponível: " + heroi.getCafeina());
                    Thread.sleep(3500);
                    if(heroi.getCafeina() == 0){
                        System.out.println("Acabou sua cafeína :(");
                    }
                }
                else if(acao == 3){ //escolheu encerrar o turno
                    System.out.println("Certeza?! Tá bom... Encerrando turno");
                }
                else { //o usuário (burro) não digitou nenhum dos 3
                    System.out.println("Você não escolheu uma ação válida. Por favor, digite um número entre 1, 2, e 3 e aperte Enter"); //como q faz pra voltar lá pra cim acho que precisa de um while, mas to sem neurônios agr
                }
            }
        
            //turno do inimigo
            if(inimigo.getVida() > 0){ //o inimigo só ataca se estiver vivo
                System.out.println("\nAgora é a vez de " + inimigo.getName());
                System.out.println("Ele usou: (insira nome legal) e deu 5 de dano. Ouch!");
                inimigo.atacar(heroi); //colocar uma função random aq pra variar entre ataque e escudo pro inimigo
                if(heroi.getVida() <= 0){
                    System.out.println("Vida de " + heroi.getName() + " = 0/" + hpHeroi);
                    break;
                }
                System.out.println("Vida de " + heroi.getName() + " = " + heroi.getVida() + "/" + hpHeroi);
                Thread.sleep(3500);
                System.out.println("\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n");
                System.out.println("--- Inimigo ---\n\n- Nome: MC102\n- Vida: " + inimigo.getVida() + " Hp\n- Escudo: " + inimigo.getEscudo());
                //SOF- vc acha q essas linhas 89 e 90 precisam msm? pq achei mt informação no terminal, e logo quando começa o novo turno ele printa de novo a msm coisa
                System.err.println("\nÉ sua vez novamente!");
                Thread.sleep(3500);
            }
        }


        if(heroi.getVida() < 0){
            System.out.println("\nVocê reprovou :(");
        }                inimigo.atacar(heroi); //colocar uma função random aq pra variar entre ataque e escudo pro inimigo
        if(inimigo.getVida() < 0){
                System.out.println("\nVocê passou :)");
        }
        scanner.close();
    }   
}


//DIU tem q botar q a vida nn pode ser negativa e se vc mata o inimigo ele ainda da um ataque (resolvido)
//tbm tem q botar pro turno do heroi encerrar imediatamente se o bixo morre (resolvido)
//SOF - tem que levar em conta o escudo, pq se o héroi usa um escudo, e o bixo da 5 de dano, tira 5 da vida, ao inves de 2 do escudo e 3 da vida
//eu coloquei uns Thread.sleep(4000), é pro tempo entre os prints, tá em milisegundo (4000 = 4s), se quiser aumentar/diminuir, fica a vontade