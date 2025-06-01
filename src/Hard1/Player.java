package Hard1;

public class Player {
    private String name;//имя игрока
    private Card[] hund;//массив для хранения карт в руке игрока
    private int cardCount; //количество карт в руке игрока

    public Player(String name) {
        this.name = name;
        hund = new Card[10];
        cardCount = 0;
    }

    public void addCard(CardDesk deck) {
        if (cardCount >= hund.length) {
            System.out.println("Рука игрока переполнена!");
            return;
        } else {
            Card newCard = deck.dealCard();
            if (newCard != null) { // Проверяем, что карта взята успешно
                hund[cardCount] = newCard;
                cardCount++;
            }
        }
    }

    public Card[] getCards() {
        return hund;
    }

    public int calculateScore() {
        int score = 0;
        int aceCount = 0;
        for (int i = 0; i < cardCount; i++) {
            Card card = hund[i];
            score += card.getWeight();

            if (card.getValue().equals("Туз")) {
                aceCount++;
            }
        }
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
        return score;
    }

    public int getCardCount() {
        return cardCount;
    }

    public void reset() {
        hund = new Card[10]; // Создаем новый массив
        cardCount = 0;       // Обнуляем счетчик карт
    }
}
