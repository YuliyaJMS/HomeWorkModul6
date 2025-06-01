package Hard2;

    public class Ship {
        private int length; // Длина корабля
        private int x; // Координата X
        private int y; // Координата Y
        private boolean isHorizontal; // Горизонтальная или вертикальная ориентация

        // Конструктор
        public Ship(int length, int x, int y, boolean isHorizontal) {
            this.length = length;
            this.x = x;
            this.y = y;
            this.isHorizontal = isHorizontal;
        }

        // Геттеры и сеттеры
        public int getLength() {
            return length;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean isHorizontal() {
            return isHorizontal;
        }
    }
