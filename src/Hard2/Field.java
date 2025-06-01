package Hard2;

public class Field {
    private int[][] board; // Массив для поля 10x10
    private final int SIZE = 10; // Размер поля

    // Конструктор: создаем пустое поле
    public Field() {
        this.board = new int[SIZE][SIZE]; // Инициализируем массив размером 10x10
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = 0; // Заполняем все клетки значением 0 (пусто)
            }
        }
    }

    // Метод для отображения поля на экране
    public void display() {
        System.out.print("   "); // Отступ для букв сверху
        for (int i = 0; i < SIZE; i++) {
            System.out.print((char) ('A' + i) + " "); // Выводим буквы A-J
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " "); // Выводим номера строк (1-10)
            if (i + 1 < 10) System.out.print(" "); // Для выравнивания
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) {
                    System.out.print(". "); // Пустая клетка
                } else if (board[i][j] == 1) {
                    System.out.print("O "); // Корабль
                } else if (board[i][j] == 2) {
                    System.out.print("X "); // Подбитый корабль
                } else if (board[i][j] == -1) {
                    System.out.print("* "); // Промах
                }
            }
            System.out.println();
        }
    }

    // Метод для размещения корабля
    public boolean placeShip(int x, int y, int length, boolean isHorizontal) {
        // Проверяем, что корабль помещается на поле
        if (isHorizontal && y + length > SIZE) return false;
        if (!isHorizontal && x + length > SIZE) return false;

        // Проверяем, что все клетки свободны
        for (int i = 0; i < length; i++) {
            if (isHorizontal) {
                if (board[x][y + i] != 0) return false;
            } else {
                if (board[x + i][y] != 0) return false;
            }
        }

        // Размещаем корабль
        for (int i = 0; i < length; i++) {
            if (isHorizontal) {
                board[x][y + i] = 1;
            } else {
                board[x + i][y] = 1;
            }
        }
        return true;
    }

    // Метод для обработки выстрела
    public int shoot(int x, int y) {
        if (board[x][y] == 1) { // Если попали в корабль
            board[x][y] = 2; // Отмечаем как подбитый
            return 1; // Возвращаем "Попал"
        } else if (board[x][y] == 0) { // Если промах
            board[x][y] = -1; // Отмечаем как промах
            return 0; // Возвращаем "Промах"
        } else { // Если уже стреляли сюда
            return -1; // Возвращаем "Недопустимый ход"
        }
    }

    // Метод для проверки победы
    public boolean areAllShipsSunk() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 1) {
                    return false; // Есть неподбитые корабли
                }
            }
        }
        return true; // Все корабли подбиты
    }
}
