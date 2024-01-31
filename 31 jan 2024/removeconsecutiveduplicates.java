import java.util.Scanner;

public class removeconsecutiveduplicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1 = scanner.nextLine();
        

        String output1 = removeConsecutiveDuplicates(str1);

       
        System.out.println( output1);

        
    }

    public static String removeConsecutiveDuplicates(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        StringBuilder result = new StringBuilder();
        result.append(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            char previousChar = str.charAt(i - 1);

            if (currentChar != previousChar) {
                result.append(currentChar);
            }
        }

        return result.toString();
    }
}
