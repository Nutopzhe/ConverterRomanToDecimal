import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a roman number to be converted to decimal: ");
        String romanString = bufferedReader.readLine();
        System.out.println("Conversion result equals = " + romanToInteger(romanString));
    }

    public static int romanToInteger(String s) {
        int lastNumber = 0;
        int decimal = 0;
        String romanNumeral = s.toUpperCase();

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char convertToDecimal = romanNumeral.charAt(i);

            switch (convertToDecimal) {
                case 'I' -> {
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                }
                case 'V' -> {
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                }
                case 'X' -> {
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                }
                case 'L' -> {
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                }
                case 'C' -> {
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                }
                case 'D' -> {
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                }
                case 'M' -> {
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                }
                default -> {
                    System.out.println("This is not roman number. Please try again");
                    System.exit(0);
                }
            }
        }
        return decimal;
    }

    public static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
