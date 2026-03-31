# A Jornada no IC 💻
*Feito por:*
*- Diulia Ribeiro Hostalácio / RA: 205305*
*- Sofia Bravim Canal De Seta / RA: 252273*

## Introdução:
    - Este projeto faz parte da disciplina **MC322 - 2026** e foi insipirado na experiência de graduação de um aluno do Instituto de Computação, em busca do tão sonhado diploma.

## Descrição:
    - Este é um jogo via Terminal que funciona a partir de decisões tomadas pelo usuário para definir o progresso da batalha.
    Aqui chamaremos o usuário interagindo no Terminal de 'Jogador'.

    - O começo: o Jogador pode começar escolhendo o nome do personagem que jogará a campanha. Aqui, o personagem iniciará sempre como um calouro que acabou de entrar no curso de computação da Unicamp, e se tornou um novo aluno do IC. O personagem, aqui, é classificado como 'Entusiasta de Programação', sem muitos conhecimentos prévios de programação, mas vontade de aprender!

    - Após a escolha do nome do personagem, a batalha contra o primeiro adversário, MC102, começa. O intuito deste jogo é retratar de forma lúdica o caminho que os alunos devem tomar, avançando de adversário em adversário, ou seja, de disciplina em disciplina, a fim de finalmente alcançar o diploma de 'Computeiro'.

        ### Dentro das Batalhas:
        - O inimigo começa cada turno anunciando sua intenção, qual ação será realizada.
        - As batalhas funcionam em um esquema de turnos, onde o personagem começa atacando, podendo escolher entre 3 tipos de ações diferentes: dar dano, receber um escudo, ou aplicar um efeito; de acordo com as cartas que forem compradas da pilha e que estiverem na mão do jogador - quantas vezes quiser - até sua energia acabar, com o intuito de derrotar o inimigo, no caso dessa implementação do jogo, MC102.
        - As Cartas de Dano e Escudo são temáticas e relacionadas com os artifícios usados e necessários na vida real para permitir a aprovação dos alunos nas disciplinas, como, ir em monitorias e baixar o VSCode, tornando a experiência do jogo ainda mais imersiva.
        - O dano sofrido pelo personagem ocorre a partir de ações das disciplinas (nesse caso, 'time limit'), que representam dificuldades características, que os estudantes passam durante os semestres.
        - Após cada turno, o personagem terá seu escudo zerado, sua cafeína recarregada e sua mão completamente descartada.
        - Efeitos Acumuláveis: Agora, tanto o personagem quanto o inimigo podem ser afligidos por efeitos que se acumulam (Burnout e Lock-in). Cada acúmulo altera a intensidade ou a duração do efeito, adicionando uma camada estratégica de longo prazo às batalhas.
        - Burnout (Veneno): Representa o acúmulo de estresse e cansaço. No final de cada turno do jogador, a entidade com Burnout sofre dano direto igual ao número X de acúmulos e, em seguida, o valor de acúmulos é reduzido em 1.
        - Lock-in (Força): Representa o estado de hiperfoco nos estudos. Enquanto este efeito estiver ativo, o dano de todos os ataques realizados pela entidade é aumentado em um valor X igual ao número de acúmulos de Lock-in.
        - No ínicio de cada nova rodada, 4 novas cartas são distribuídas para o jogador e ele poderá escolher quaisquer delas para jogar.
        - Caso a pilha de compra termine, no começo ou no meio de uma rodada, a pilha de descarte é reembaralhada e o jogador pode comprar novamente da pilha de compra.
        - Inimigos com Múltiplas Ações: O oponente MC102 tornou-se mais imprevisível, sendo capaz de escolher aleatoriamente entre atacar, aplicar o efeito de Burnout no jogador, fortalecer-se com Lock-in ou preparar defesas com Escudo
        
        ### Fim da Batalha:
        - O fim se dá de duas formas:
            . Caso o jogador ganhe, ou seja, mate o inimigo antes de perder toda a sua vida, significa que o calouro foi aprovado e passou na matéria!
            . Caso o jogador perca, ou seja, perca sua vida antes de matar o inimigo, significa que o calouro foi reprovado e precisará refazer a matéria.


## Compilação e execução do programa:
    - Para compilar o programa basta utilizar este comando no terminal:
        ```javac -d bin $(find src -name "*.java")```
    
    - Para executar o programa, faça:
        ```java -cp bin App```

Aproveite a experiência imersiva deste jogo incrível!

*Disclaimer: Este jogo é uma homenagem ao IC e tudo que ele nos proporciona durante a graduação, e em nenhum momento tem a intenção de ofender ninguém e nem a instituição :D*