package Hard2;

    import java.util.Scanner;

    public class Game {
        private Field playerField; // Поле игрока
        private Field computerField; // Поле компьютера
        private Scanner scanner; // Для ввода данных

        // Конструктор
        public Game() {
            this.playerField = new Field();
            this.computerField = new Field();
            this.scanner = new Scanner(System.in);
        }

        // Метод для запуска игры
        public void start() {
            initializeFields(); // Инициализация полей
            playGame(); // Запуск основного цикла игры
        }

        // Метод для инициализации полей
        private void initializeFields() {
            placeComputerShips(); // Компьютер размещает свои корабли
            placePlayerShips(); // Игрок размещает свои корабли
        }

        // Метод для размещения кораблей компьютера
        private void placeComputerShips() {
            int[] shipSizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // Размеры кораблей

            for (int size : shipSizes) {
                while (true) {
                    int x = (int) (Math.random() * 10); // Случайная координата X
                    int y = (int) (Math.random() * 10); // Случайная координата Y
                    boolean isHorizontal = Math.random() < 0.5; // Случайная ориентация

                    if (computerField.placeShip(x, y, size, isHorizontal)) {
                        break; // Корабль успешно размещен
                    }
                }
            }
        }

        // Метод для размещения кораблей игрока
        private void placePlayerShips() {
            int[] shipSizes = {4, 3, 3, 2, 2, 2, 1, 1, 1, 1}; // Размеры кораблей

            for (int size : shipSizes) {
                while (true) {
                    System.out.println("Разместите корабль длиной " + size + ":");
                    System.out.print("Введите координату (например, A1): ");
                    String input = scanner.nextLine().toUpperCase();
                    int x = input.charAt(1) - '1'; // Преобразование строки в координату X
                    int y = input.charAt(0) - 'A'; // Преобразование строки в координату Y

                    System.out.print("Ориентация (H - горизонтально, V - вертикально): ");
                    char orientation = scanner.nextLine().charAt(0);

                    boolean isHorizontal = orientation == 'H';

                    if (playerField.placeShip(x, y, size, isHorizontal)) {
                        break; // Корабль успешно размещен
                    } else {
                        System.out.println("Некорректное размещение. Попробуйте снова.");
                    }
                }
            }
        }

        // Метод для основного цикла игры
        private void playGame() {
            boolean playerTurn = true; // Флаг, чей ход

            while (true) {
                if (playerTurn) {
                    System.out.println("\nПоле игрока:");
                    playerField.display();
                    System.out.println("\nПоле компьютера:");
                    computerField.display();

                    System.out.println("Ваш ход. Введите координату (например, A1): ");
                    String input = scanner.nextLine().toUpperCase();
                    int x = input.charAt(1) - '1';
                    int y = input.charAt(0) - 'A';

                    int result = computerField.shoot(x, y);

                    if (result == 1) {
                        System.out.println("Попал!");
                    } else if (result == 0) {
                        System.out.println("Промах!");
                        playerTurn = false; // Передача хода компьютеру
                    } else {
                        System.out.println("Вы уже стреляли в эту клетку. Попробуйте снова.");
                    }

                    if (computerField.areAllShipsSunk()) {
                        System.out.println("Поздравляем! Вы победили!");
                        break;
                    }
                } else {
                    // Ход компьютера
                    int x = (int) (Math.random() * 10);
                    int y = (int) (Math.random() * 10);

                    int result = playerField.shoot(x, y);

                    if (result == 1) {
                        System.out.println("Компьютер попал в ваш корабль!");
                    } else if (result == 0) {
                        System.out.println("Компьютер промахнулся!");
                        playerTurn = true; // Передача хода игроку
                    }

                    if (playerField.areAllShipsSunk()) {
                        System.out.println("Компьютер победил! GAME OVER.");
                        break;
                    }
                }
            }
        }
    }
