package Hard1;

import java.util.Random;

public class CardDesk {
    private Card[] cards;
    private int topCardIndex;

    public CardDesk() {
        cards = new Card[52];
        topCardIndex = 0;

        String[] suits = {"Червы", "Бубны", "Трефы", "Пики"}; // Масти
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Валет", "Дама", "Король", "Туз"}; // Значения карт
        int cardIndex = 0;// Индекс для заполнения массива

        for (String suit : suits) {
            for (String value : values) {
                if (cardIndex >= cards.length) {
                    System.out.println("Ошибка: превышение размера массива");
                    break;
                }
                int weight = getCardWeight(value);
                cards[cardIndex] = new Card(value + " " + suit, weight);
                cardIndex++;
            }
        }
        shuffle(); // Перемешиваем карты после создания колоды
    }

    private int getCardWeight(String value) {
        switch (value) {
            case "Валет":
            case "Дама":
            case "Король":
                return 10; // Вес этих карт всегда 10
            case "Туз":
                return 11; // Туз имеет вес 11 (позже можно изменить на 1)
            default:
                return Integer.parseInt(value); // Для карт от "2" до "10" вес равен их номиналу
        }
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Генерируем случайный индекс
            // Меняем местами карты с индексами i и j
            Card temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
    }
    public Card dealCard() {
        if (topCardIndex >= cards.length) {
            System.out.println("Ошибка, колода пуста");
            return null;
        } else {
            Card currentCard = cards[topCardIndex];
            topCardIndex++;
            return currentCard;
        }
    }
}
