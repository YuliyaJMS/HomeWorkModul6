package Middle2;

public class Player {
    private String name;
    public char symbol;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    public String getName() {
        return name;
    }
    public char getSymbol() {
        return symbol;
    }
}