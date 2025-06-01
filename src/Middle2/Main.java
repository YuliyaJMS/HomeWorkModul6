package Middle2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше имя ");
            String playerName = scanner.next();
            Player player = new Player(playerName, 'X');

            Game game = new Game(player); //объект
        System.out.println("Добро пожаловать в игру Крестики-нолики, " + player.getName() + "!");
        System.out.println("Вы играете за 'X', компьютер играет за 'O'.");

        while (true) {
            game.drawBoard();

            System.out.println(player.getName() + ", введите номер ячейки(1-9): ");
            int move = scanner.nextInt();
            while (move < 1 || move > 9 || !game.playerMove(move)) {
                System.out.println("Неверный ввод. Попробуйте снова.");
                move = scanner.nextInt();
            }
            if (game.isBoardFull()) {
                game.drawBoard();
                System.out.println("Ничья!");
                break;
            }
            game.computerMove();
            System.out.println("Ход компьютера: ");

                if (game.checkWinner(game.computerSymbol)) {
                    game.drawBoard();
                    System.out.println("Компьютер выиграл!");
                    break;
            }
            if (game.isBoardFull()) {
                game.drawBoard();
                System.out.println("Ничья!");
                break;
            }
        }
    }
}
