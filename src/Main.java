import java.util.Scanner;

public class Main {
    public static Scanner scanner;
    private static int currentBase = 10;
    public static void main(String[] args) {
        System.out.println("===КОНСОЛЬНЫЙ КАЛЬКУЛЯТОР===");
        System.out.println("Поддерживаемые системы: 2, 8, 10, 16");
        System.out.println("По умолчанию: десятичная система счисления");
        scanner = new Scanner(System.in);
        while(true){
            try{
                System.out.println();
                System.out.println(getCurrentBase());
                System.out.println("Что вы хотите сделать?");
                System.out.println("1 - Сменить систему счисления");
                System.out.println("2 - Выполнить вычисление");
                System.out.println("3 - Выйти из программы");

                System.out.print("Ваш выбор (1/2/3): ");
                String choice = scanner.nextLine();

                switch (choice) {
                    case "1":
                        changeBase();
                        break;
                    case "2":
                        performCalculation();
                        break;
                    case "3":
                        System.out.println("Программа завершена.");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Ошибка, выберите 1, 2 или 3");
                        break;
                }
            }
            catch(Exception e){
                System.out.println("Ошибка: " + e.getMessage());

            }
        }
    }
    private static String getCurrentBase() {
        String baseName;
        switch (currentBase) {
            case 2: baseName = "ДВОИЧНАЯ (2)"; break;
            case 8: baseName = "ВОСЬМЕРИЧНАЯ (8)"; break;
            case 10: baseName = "ДЕСЯТИЧНАЯ (10)"; break;
            case 16: baseName = "ШЕСТНАДЦАТЕРИЧНАЯ (16)"; break;
            default: baseName = "НЕИЗВЕСТНАЯ";
        }
        return "=== ТЕКУЩАЯ СИСТЕМА: " + baseName + " ===";
    }
    private static void changeBase(){
        System.out.println("Выберите систему счисления:");
        System.out.println("2 - Двоичная");
        System.out.println("8 - Восьмеричная");
        System.out.println("10 - Десятичная");
        System.out.println("16 - Шестнадцатеричная");
        System.out.print("Ваш выбор: ");

        try {
            int newBase = Integer.parseInt(scanner.nextLine());
            if (newBase == 2 || newBase == 8 || newBase == 10 || newBase == 16) {
                currentBase = newBase;
                System.out.println("Система счисления изменена на " + currentBase);
            } else {
                System.out.println("Ошибка: допустимы только 2, 8, 10, 16 с.с.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число");
        }
    }
    public static void performCalculation(){
        System.out.print("Введите 1 число: ");
        String number1 = InputN.input(currentBase);
        System.out.print("Введите 2 число: ");
        String number2 = InputN.input(currentBase);
        System.out.print("Введите операцию: ");
        String operation = InputChar.inputOperation();

        String result = calculate(number1, number2, operation);
        System.out.println("\n=== РЕЗУЛЬТАТ ===");
        System.out.print(result);
    }
    private static String calculate(String number1, String number2, String operation) {
        BaseCalculator calculator = new BaseCalculator();
        switch (operation) {
            case "+":
                return calculator.add(number1, number2, currentBase);
            case "-":
                return calculator.subtract(number1, number2, currentBase);
            case "*":
                return calculator.multiply(number1, number2, currentBase);
            case "/":
                return calculator.divide(number1, number2, currentBase);
            case "%":
                return calculator.remainder(number1, number2, currentBase);
            default:
                throw new IllegalArgumentException("Неизвестная операция: " + operation);
        }
    }
}