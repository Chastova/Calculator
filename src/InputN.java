
public class InputN {
    public static String input(int base){
        while(true){
            String input = Main.scanner.nextLine().trim().toUpperCase();
            try{
                if(base==2){
                    if (!input.matches("^-?[01]+$")) {
                        throw new IllegalArgumentException("Для двоичной системы допустимы только 0 и 1");
                    }
                }
                else if(base==8){
                    if (!input.matches("^-?[0-7]+$")) {
                        throw new IllegalArgumentException("Для двоичной системы допустимы только 0 и 1");
                    }
                }
                else if(base==10){
                    if (!input.matches("-?[0-9]+$")) {
                        throw new IllegalArgumentException("Для десятичной системы допустимы цифры 0-9");
                    }
                }
                else if(base==16){
                    if (!input.matches("^-?[0-9A-F]+$")) {
                        throw new IllegalArgumentException("Для шестнадцатеричной системы допустимы 0-9 и A-F");
                    }
                }
                return input;
            }
            catch(IllegalArgumentException e){
                System.out.print("Ошибка: " + e.getMessage() + ". Введите число заново: ");
            }
        }
    }
}
