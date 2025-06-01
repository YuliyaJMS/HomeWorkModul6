package Hard1;

public class Card {
    public String value;
    public int weight;

    public Card(String value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public String getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return value;
    }
}
