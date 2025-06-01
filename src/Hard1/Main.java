package Hard1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать, введите свое имя: ");
        String name = scanner.nextLine();
        Boolean playAgain = true;

        while (playAgain) {
            System.out.println("Начинаем новую игру " + name);

            CardDesk deck = new CardDesk();
            Player player = new Player("Игрок");
            Player dealer = new Player("Дилер");

            player.addCard(deck);
            player.addCard(deck);

            dealer.addCard(deck);
            dealer.addCard(deck);


            //вывод текущих карт, ход игрока
            boolean playerTurn = true;
            while (playerTurn) {
                System.out.println("Ваши карты: ");
                for (int i = 0; i < player.getCardCount(); i++) {
                    System.out.print(player.getCards()[i] + " ");
                }
                System.out.println();
                System.out.println("Ваша сумма очков: " + player.calculateScore());
                System.out.println("Хотите взять еще карту? (да/нет)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Да")) {
                    player.addCard(deck);
                    if (player.calculateScore() > 21) {
                        System.out.println("Вы проиграли, перебор!");
                        playerTurn = false;
                    }
                } else {
                    playerTurn = false;
                }
            }
            //ход диллера
            //System.out.println("Ход дилера...");
            System.out.println("Карты дилера: ");
            for (int i = 0; i < dealer.getCardCount(); i++) {
                System.out.print(dealer.getCards()[i] + " ");
            }
            System.out.println();
            System.out.println("Сумма очков дилера: " + dealer.calculateScore());

            int playerScore = player.calculateScore();
            int dealerScore = dealer.calculateScore();

            //определить победителя
            System.out.println("Сумма ваших очков: " + player.calculateScore());

            if (playerScore > 21) {
                System.out.println("Вы проиграли!");
            } else if (dealerScore > 21) {
                System.out.println("Вы выиграли!");
            } else if (playerScore > dealerScore) {
                System.out.println("Вы выиграли!");
            } else if (playerScore < dealerScore) {
                System.out.println("Вы проиграли!");
            } else {
                System.out.println("Ничья!");
            }
            // Повторная игра
            System.out.println("Хотите сыграть снова? (да/нет)");
            String choice = scanner.nextLine();
            playAgain = choice.equalsIgnoreCase("да");

            player.reset();
            dealer.reset();
        }
        System.out.println("Спасибо за игру!");
    }
}