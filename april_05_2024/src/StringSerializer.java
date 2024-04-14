import java.util.Scanner;

public class StringSerializer {
    public static String serialize(String[] A) {
        StringBuilder serializedString = new StringBuilder();
        for (String str : A) {
            int length = str.length();
            serializedString.append(str).append(length).append("~");
        }
        return serializedString.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of strings in the array: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        String[] A = new String[n];
        System.out.println("Enter the strings in the array:");
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextLine();
        }

        String serializedString = serialize(A);
        System.out.println("Serialized string: " + serializedString);

        scanner.close();
    }
}
