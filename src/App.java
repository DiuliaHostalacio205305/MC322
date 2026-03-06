import java.util.Scanner;

public class App {
    public static void main(String[] args){
        Heroi heroi = new Heroi("Calouro", 40, 0, 3);
        Inimigo inimigo = new Inimigo("MC102", 20, 0);
        while(heroi.estaVivo() && inimigo.estaVivo()){

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
            System.out.println("Vamos começar a batalha!\nNessa primeira fase, seu oponente será o 'MC102'\n\n --- Personagem ---\n\n- Nome: " + heroi.getName() + "\n- Vida: " + heroi.getVida() + " Hp\n- Escudo: " + heroi.getEscudo() + "\n- Cafeína: " + heroi.getCafeina() + "\n\n--------------------\n");
            System.out.println("--- Inimigo ---\n\n- Nome: MC102\n- Vida: 20 Hp\n- Escudo: 0\n");
            System.out.println("Preparado? Escolha uma ação:\n\n- 1: Usar Carta de Ataque -> Cafeína - 1\n- 2: Usar Carta de Escudo -> Cafeína - 1\n- 3: Encerrar turno\n\n- Cafeína disponível: " + heroi.getCafeina() + "\n");
            System.out.println("Digite o número da ação escolhida:");            
            int acao = scanner.nextInt();
            System.out.println("Ótima escolha! Você escolheu:");
            //colocar uma linha dentro de cada if dizendo qual foi a escolha
            if(acao == 1){ //escolheu atacar

            }
            else if(acao == 2){ //escolheu usar escudo

            }
            else if(acao == 3){ //escolheu encerrar o turno

            }
            else { //o usuário (burro) não digitou nenhum dos 3

            }
            
            heroi.receberDano(50); //coloquei apenas pra matar o programa por enquanto
        }
        
    }
}
