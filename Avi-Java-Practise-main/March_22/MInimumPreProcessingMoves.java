import java.util.Scanner;

public class MInimumPreProcessingMoves {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            String A = scanner.next();
            String B = scanner.next();
            int result = minPreprocessingMoves(A, B);
            System.out.println(result);

        scanner.close();
    }

    public static int minPreprocessingMoves(String A, String B) {
        if (A.length() != B.length()) {
            return -1; // Assuming strings need to be of equal length
        }
        int[] charCountA = new int[26];
        int[] charCountB = new int[26];

        for (int i = 0; i < A.length(); i++) {
            charCountA[A.charAt(i) - 'a']++;
            charCountB[B.charAt(i) - 'a']++;
        }

        int preprocessMoves = 0;
        for (int i = 0; i < 26; i++) {
            preprocessMoves += Math.abs(charCountA[i] - charCountB[i]);
        }

        return preprocessMoves / 2; // Now correctly calculates the minimum number of moves
    }

}