package Middle4;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GameStart {
    private List<PlayerFour> playerFours;
    private int targetNumber;
    private int currentSum;

    public GameStart(List<PlayerFour> playerFours) {
        this.playerFours = playerFours;
        this.currentSum = 0;
    }

    public int generateTargetNumber() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        return targetNumber;

    }

    public int getPlayerInput(int playerIndex) {
        PlayerFour currentPlayer = playerFours.get(playerIndex);

        String playerName = currentPlayer.getName();
        System.out.print(playerName + ", введите число: ");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                int number = Integer.parseInt(scanner.nextLine());
                if (number > 0) {
                    return number; // Возвращаем число, если оно корректно
                } else {
                    System.out.print("Число должно быть больше 0. Попробуйте снова: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Введите корректное число: ");
            }
        }
    }

    public void determineWinner(int loserIndex) {
        if (loserIndex == -1) {
            System.out.println("Компьютер проиграл!");
            for (PlayerFour player : playerFours) {
                player.incrementScore(); // Увеличиваем счетчик побед у всех игроков
            }
        } else {
            PlayerFour loser = playerFours.get(loserIndex); // Находим проигравшего игрока
            System.out.println("Участник: " + loser.getName() + " проиграл!");

            // Увеличиваем счетчик побед у остальных игроков
            for (int i = 0; i < playerFours.size(); i++) {
                if (i != loserIndex) { // Пропускаем проигравшего игрока
                    playerFours.get(i).incrementScore();
                }
            }
        }
    }

    public void printResults() {
        System.out.println("Загаданное число было " + targetNumber);
        System.out.println("Итоговый счет:");
        for (PlayerFour player : playerFours) {
            System.out.println(player.getName() + ": " + player.getScore() + " побед");
        }
    }

    public void startGame() {
        this.targetNumber = generateTargetNumber();
        System.out.println("Компьютер загадал число от 1 до 100");
        while (true) {
            for (int i = 0; i < playerFours.size(); i++) {
                PlayerFour currentPlayer = playerFours.get(i);
                int input = getPlayerInput(i);
                updateCurrentSum(input);
                if (currentSum >= targetNumber) {
                    determineWinner(i);
                    printResults();
                    return;
                }
            }
        }
    }
    public void updateCurrentSum(int number) {
        currentSum += number;
        System.out.println("Текущая сумма: " + currentSum);
    }
}





