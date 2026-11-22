
import java.util.Scanner;
import java.util.Locale;

public class Calculator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        System.out.print("Введите первое число: ");
        double result = scanner.nextDouble();

        while (true) {

            System.out.print("Введите операцию (+, -, *, /, C - сброс, S - выход): ");

            String command = scanner.next();

            if (command.equalsIgnoreCase("s")) {
                System.out.println("Калькулятор выключен.");
                break;
            }

            if (command.equalsIgnoreCase("c")) {
                result = 0;
                System.out.println("Результат сброшен: " + result);
                continue;
            }

            char operation = command.charAt(0);

            if (operation != '+' && operation != '-' &&
                operation != '*' && operation != '/') {

                System.out.println("Ошибка: неподдерживаемая операция");
                continue;
            }

            System.out.print("Введите второе число: ");
            double secondOperand = scanner.nextDouble();

            switch (operation) {
                case '+':
                    result += secondOperand;
                    break;

                case '-':
                    result -= secondOperand;
                    break;

                case '*':
                    result *= secondOperand;
                    break;

                case '/':
                    if (secondOperand == 0) {
                        System.out.println("Ошибка: деление на ноль");
                    } else {
                        result /= secondOperand;
                    }
                    break;
            }

            // Вывод результата
            System.out.println("Текущий результат: " + result);
        }

        scanner.close();
    }
}
