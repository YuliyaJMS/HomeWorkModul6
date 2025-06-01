package Middle1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите какое действие хотите выполнить: умножение, сложение, вычитание или деление: ");
        String choice = scanner.next();
        Calculator calculator = new Calculator();//Это объект
        System.out.println("Введите первое число: ");
        int number1 = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int number2 = scanner.nextInt();

        switch(choice.toLowerCase()) {
            case "сложение":
                System.out.println("Результат сложения " + calculator.add(number1, number2));
                break;
            case "вычитание":
                System.out.println("Результат вычитания " + calculator.subtract(number1, number2));
                break;
            case  "умножение":
                System.out.println("Результат умножения " + calculator.multiply(number1, number2));
                break;
            case "деление":
                System.out.println("Результат деления " + calculator.division(number1, number2));
                break;
            default:
                System.out.println("Неверный выбор действий");
                break;
        }
        }
    }