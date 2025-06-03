package Middle3;

import java.util.Random;

public class GamePack {
    private PlayerPack player;
    private int sticks;
    static final int INITIAL_STACKS = 20;


    public GamePack(PlayerPack player, int sticks) {
        this.player = player;
        this.sticks = sticks;
    }

    public void startGame() {
        boolean playerTurn = determineFirstPlayer();

        System.out.println("Игра начинается! Количество палочек " + sticks);
        if (playerTurn) {
            System.out.println("Первым ходит игрок. ");
        } else {
            System.out.println("Первым ходит компьютер.");
        }
        playGame(playerTurn);
    }


    public boolean determineFirstPlayer() {
        Random random = new Random();
        return random.nextBoolean();
    }

    public void playGame(boolean playerTurn) {
        while (this.sticks > 1) {
            if (playerTurn) {
                int playerMove = player.getPlayerMove(this.sticks);
                System.out.println("Игрок взял " + playerMove + " палочки.");
                this.sticks -= playerMove;
            } else {
                int computerMove = player.getComputerMove(this.sticks);
                System.out.println("Компьютер взял " + computerMove + " палочки");
                this.sticks -= computerMove;
            }
            System.out.println("Осталось палочек: " + this.sticks);
            playerTurn = !playerTurn;
        }
        if (playerTurn) {
            System.out.println("Вы проиграли! Компьютер оставил вам одну палочку.");
        } else {
            System.out.println("Поздравляем! Вы победили!");
        }
    }


    public void resetGame() {
       this.sticks = INITIAL_STACKS;
    }
}
