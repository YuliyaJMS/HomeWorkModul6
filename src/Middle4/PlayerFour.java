package Middle4;

public class PlayerFour {
    /*private*/ String name;
    /*private*/ int score;

    public PlayerFour(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
        //Возвращает имя игрока
    }

    public int getScore() {
        return score;
        //Возвращает текущий счетчик побед
    }

    public void incrementScore() {
        score++;
        //Увеличивает счётчик побед на 1.

    }
}

