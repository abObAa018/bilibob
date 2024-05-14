package application; 

import java.util.Scanner;

public class LogicalCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Введите логическое выражение (например, A AND B):");
            String input = scanner.nextLine();

            String[] tokens = input.split(" ");
            if(tokens.length != 3) {
                System.out.println("Некорректный ввод. Пожалуйста, введите выражение в формате 'A AND B'.");
                return;
            }

            boolean A = false;
            boolean B = false;

            System.out.println("Введите значение переменной A (true/false):");
            String valueA = scanner.nextLine();
            if(valueA.equalsIgnoreCase("true")) {
                A = true;
            }

            System.out.println("Введите значение переменной B (true/false):");
            String valueB = scanner.nextLine();
            if(valueB.equalsIgnoreCase("true")) {
                B = true;
            }

            boolean result = false;
            if(tokens[1].equalsIgnoreCase("AND")) {
                result = A && B;
            } else if(tokens[1].equalsIgnoreCase("OR")) {
                result = A || B;
            } else if(tokens[1].equalsIgnoreCase("NOT")) {
                result = !A;
            } else {
                System.out.println("Некорректная операция. Поддерживаются только операции AND, OR, NOT.");
                return;
            }

            System.out.println("Результат: " + result);
        } finally {
            if(scanner != null) {
                scanner.close();
            }
        }
    }
}
