package project;

import java.util.Random;

public class Craps {
    //As variáveis estáticas são variáveis da classe, elas independem do objeto gerado pela classe.
    //As variáveis privadas são assim declardas, para que elas não possam ser alteradas fora da classe.
    //Quando é declarada como "final" ela tem seu valor fixo, não sendo alerado durante a execuçõa.
    //As enums, ou enumerações, são um conjunto de valores pré definidos.

    private static final Random randomNumbers = new Random();

    private enum Status {CONTINUE, WON, LOST};
    private static final int SNAKE_EYES = 2;
    private static final int SEVEN = 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;
    private static final int TREY = 3;


    public static void main(String[] args) {
        int myPoint = 0;//meus pontos inicializa em 0

        Status gameStatus;
        int sumOfDice = rollDice();//"chama o método rollDice para gerar os números


        switch (sumOfDice) {//se a soma dos dados for 7 ou 11, você janhou.
            case SEVEN:
            case YO_LEVEN:
                gameStatus = Status.WON;
                break;
            case SNAKE_EYES://se a soma dos dados for 2, 3 ou 12, você perdeu.
            case TREY:
            case BOX_CARS:
                gameStatus = Status.LOST;
                break;
            default://para outros resultados dos dados, você continua o jogo
                gameStatus = Status.CONTINUE;
                myPoint = sumOfDice;//seus pontos recebem os valores da nova jogada
                System.out.println("Pontos: " + myPoint);//é exibido na tela seus pontos
        }
        while (gameStatus == Status.CONTINUE) {//enquanto ainda não ganhou ou perdeu:
            sumOfDice = rollDice();//sua soma recebe
            if (sumOfDice == myPoint) {//se a soma dos dados é igual aos seus pontos você ganha
                gameStatus = Status.WON;
            } else {//senão, se a soma dos dados for 7, você perde
                if (sumOfDice == SEVEN) {
                    gameStatus = Status.LOST;
                }
            }
            if (gameStatus == Status.WON) {//se você ganhou, é impresso na tela uma mensagem que vc venceu
                System.out.println("Você venceu!!");
            } else {//senão, é impresso uma mensagem que vc perdeu
                System.out.println("Você perdeu..");
            }
        }
    }


//O método estático rollDice gera 2 valores randômicos entre 1 e 6
//faz a soma desses valores e retorna esse valor.

//    private static int rollDice() {
//        int die1 = 1 + randomNumbers.nextInt(6);
//        int die2 = 1 + randomNumbers.nextInt(6);
//        int sum = die1 + die2;
//
//        System.out.println("Soma: " + sum);
//        return sum;
//    }

//método com os dados viciados. A soma sempre resultará em 6.
    private static int rollDice() {
        int min = 3;
        int max = 3;
        int die1 = min + randomNumbers.nextInt((max - min) + 1);
        int die2 = min + randomNumbers.nextInt((max - min) + 1);
        int sum = die1 + die2;
        System.out.println("Soma: " + sum);
        return sum;
    }

}

