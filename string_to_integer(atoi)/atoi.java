import java.util.Scanner;

public class atoi {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        // Trim leading and trailing spaces
        s = s.trim();
        if (s.isEmpty()) {
            return 0;
        }

        int sign = 1;
        int index = 0;

        // Handle sign (+ or -)
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++; 
        }

        int result = 0;

        // Convert characters to integer
        while (index < s.length() && Character.isDigit(s.charAt(index))) {
            int digit = s.charAt(index) - '0';

            // Check for integer overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } 

            result = result * 10 + digit;
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        atoi solution = new atoi(); // Fix: Changed Solution to atoi
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string:");
        String input = scanner.nextLine();

        int result = solution.myAtoi(input);
        System.out.println("Converted integer: " + result);

        scanner.close();
    }
}
