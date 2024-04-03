package Feb_26;

public class Scrambled_String_GFG {

    public static int isScramble(final String A, final String B) {
        // Check if the lengths of the strings are equal
        if (A.length() != B.length()) {
            return 0;
        }

        // Check if the strings are equal
        if (A.equals(B)) {
            return 1;
        }

        // Check if the characters in the strings are the same
        int[] count = new int[26];
        for (int i = 0; i < A.length(); i++) {
            count[A.charAt(i) - 'a']++;
            count[B.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                return 0;
            }
        }

        // Partition the strings and recursively check
        int n = A.length();
        for (int i = 1; i < n; i++) {
            if ((isScramble(A.substring(0, i), B.substring(0, i)) == 1
                    && isScramble(A.substring(i), B.substring(i)) == 1)
                    || (isScramble(A.substring(0, i), B.substring(n - i)) == 1
                    && isScramble(A.substring(i), B.substring(0, n - i)) == 1)) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {


        // Example inputs
        String A1 = "we";
        String B1 = "we";
        System.out.println(isScramble(A1, B1)); // Output: 1

        String A2 = "phqtrnilf";
        String B2 = "ilthnqrpf";
        System.out.println(isScramble(A2, B2)); // Output: 0


    }
}
