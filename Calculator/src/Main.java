import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите выражение в формате: a + b, a - b, a * b или a / b, причем a и b -- целые числа, принадлежащие промежутку [0, 10]:");
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        String[] parts = input.split(" ");
        int a, b;
        char operator;
        try {
            if (parts.length != 3) {
                throw new IllegalArgumentException("Неверный формат записи!");
            }
            a = Integer.parseInt(parts[0]);
            operator = parts[1].charAt(0);
            b = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Неверный формат чисел!");
        }
        if ((a < 0 || a > 10) && (b < 0 || b > 10)) {
            throw new IllegalArgumentException(a + " и " + b + " не принадлежат промежутку [0, 10]!");
        } else if (a < 0 || a > 10) {
            throw new IllegalArgumentException(a + " не принадлежит промежутку [0, 10]!");
        } else if (b < 0 || b > 10) {
            throw new IllegalArgumentException(b + " не принадлежит промежутку [0, 10]!");
        }
        int result;
        switch (operator) {
            case '+' -> result = a + b;
            case '-' -> result = a - b;
            case '*' -> result = a * b;
            case '/' -> {
                if (b == 0) {
                    throw new IllegalArgumentException("Деление на ноль невозможно!");
                }
                result = a / b;
            }
            default -> throw new IllegalArgumentException("Неверный оператор");
        }
        return String.valueOf(result);
    }
}
