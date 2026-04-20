public class InputChar {
    public static String inputOperation(){
        while (true) {
            System.out.print("\nВведите символ операции (+, -, *, /, %): ");
            String operation = Main.scanner.nextLine().trim();
            if (operation.equals("+") ||
                    operation.equals("-") ||
                    operation.equals("*") ||
                    operation.equals("/") ||
                    operation.equals("%")) {
                return operation;
            } else {
                System.out.println("Ошибка: допустимые символы: +  -  *  /  %");
                System.out.print("Попробуйте снова.\n");
            }
        }
    }
}
