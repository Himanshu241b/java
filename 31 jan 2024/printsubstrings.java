import java.util.Scanner;

public class printsubstrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String str = scanner.nextLine();
        printAllSubstrings(str);
        scanner.close();
    }

    public static void printAllSubstrings(String str) {
        printSubstringsRecursive(str, 0, "");
    }

    public static void printSubstringsRecursive(String str, int start, String currentSubstring) {
        if (start == str.length()) {
            return;
        }

        for (int end = start + 1; end <= str.length(); end++) {
            System.out.println(currentSubstring + str.substring(start, end));
        }

        printSubstringsRecursive(str, start + 1, currentSubstring);
    }
}
