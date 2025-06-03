package Middle3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PlayerPack player = new PlayerPack("Игрок", 1);

        GamePack game = new GamePack(player, GamePack.INITIAL_STACKS);

            while (true) {
                game.startGame();

                System.out.print("Хотите сыграть ещё раз? (да/нет): ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine().toLowerCase();

                if (answer.equals("да")) {
                    game.resetGame();
                    game.startGame();
                } else {
                    System.out.println("Спасибо за игру!");
                    break;
                }
            }
        }
    }