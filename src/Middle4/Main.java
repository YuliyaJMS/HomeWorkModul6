package Middle4;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<PlayerFour> players = new ArrayList<>();
        players.add(new PlayerFour("Игрок 1"));
        players.add(new PlayerFour("Игрок 2"));


       GameStart game = new GameStart(players);
       game.startGame();
    }
}
