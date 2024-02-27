//imports
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
public class ScrambleString {

    public static void main(String[] args) {
        ScrambleString solution = new ScrambleString();
        System.out.println(solution.isScramble("we", "we")); // Output: true
        System.out.println(solution.isScramble("phqtrnilf", "ilthnqrpf")); // Output: false
    }
    public boolean isScramble(String s1, String s2) {
        // Create a memoization map
        Map<String, Boolean> memo = new HashMap<>();
        return isScrambleUtil(s1, s2, memo);
    }

    private boolean isScrambleUtil(String s1, String s2, Map<String, Boolean> memo) {
        // Check if strings s1 and s2 are equal
        if (s1.equals(s2)) {
            return true;
        }

        // Check if the strings are of different lengths or have different characters
        if (s1.length() != s2.length() || !sortedString(s1).equals(sortedString(s2))) {
            return false;
        }

        // If the current combination is already memoized, return the result
        String key = s1 + "-" + s2;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int length = s1.length();

        // Try all possible partitions
        for (int i = 1; i < length; i++) {
            // Check if strings are scrambled without swapping
            if (isScrambleUtil(s1.substring(0, i), s2.substring(0, i), memo) &&
                    isScrambleUtil(s1.substring(i), s2.substring(i), memo)) {
                memo.put(key, true);
                return true;
            }
            // Check if strings are scrambled with swapping
            if (isScrambleUtil(s1.substring(0, i), s2.substring(length - i), memo) &&
                    isScrambleUtil(s1.substring(i), s2.substring(0, length - i), memo)) {
                memo.put(key, true);
                return true;
            }
        }

        // If no partition is found, mark as False and return
        memo.put(key, false);
        return false;
    }

    // Helper function to sort characters in a string
    private String sortedString(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
