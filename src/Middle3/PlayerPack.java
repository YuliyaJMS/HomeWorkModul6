package Middle3;

import java.util.Random;
import java.util.Scanner;

public class PlayerPack {
    private String name;
    private int symbol;

    public PlayerPack(String name, int symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public int getPlayerMove(int remainingSticks) {
        Scanner scanner = new Scanner(System.in);
        int move;
        System.out.println("Сколько палочек вы хотите взять? (1,2 или 3): ");
        while (true) {
            try {
                move = Integer.parseInt(scanner.nextLine());
                if (move >= 1 && move <= 3 && move <= remainingSticks) {
                    break;
                } else {
                    System.out.println("Некорректный ввод, попробуйте снова!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Введите число, попробуйте снова");
            }
        }
        return move;

    }

    public int getComputerMove(int remainingSticks) {
        Random random = new Random();
        int move = random.nextInt(3) + 1;

        if (move > remainingSticks) {
            move = remainingSticks;
            System.out.println("Компьютер выбирает " + move + "палочек.");
        }
        return move;
    }
}
