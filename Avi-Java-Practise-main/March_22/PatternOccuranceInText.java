import java.util.ArrayList;
import java.util.List;

public class PatternOccuranceInText {
    public static void main(String[] args) {
        String text1 = "cxyzghxyzvjkxyz";
        String pattern1 = "xyz";
        printOccurrences(text1, pattern1); // Output: 2 7 13

        String text2 = "ababacabab";
        String pattern2 = "aba";
        printOccurrences(text2, pattern2); // Output: 1 3 7

        String text3 = "abcd";
        String pattern3 = "xy";
        printOccurrences(text3, pattern3); // Output: 0
    }

    public static void printOccurrences(String text, String pattern) {
        List<Integer> occurrences = findOccurrences(text, pattern);
        for (int index : occurrences) {
            System.out.print((index + 1) + " "); // 1-indexed
        }
        System.out.println();
    }

    public static List<Integer> findOccurrences(String text, String pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();
        int prime = 31;
        long patternHash = calculateHash(pattern, prime);
        long textHash = calculateHash(text.substring(0, m), prime);

        for (int i = 0; i <= n - m; i++) {
            if (patternHash == textHash && text.substring(i, i + m).equals(pattern)) {
                occurrences.add(i);
            }
            if (i < n - m) {
                textHash = recalculateHash(text, i, m, textHash, prime);
            }
        }

        return occurrences;
    }

    // method to calculate hash value of substring of text
    public static long calculateHash(String str, int prime) {
        long hash = 0;
        long pPow = 1;
        for (char c : str.toCharArray()) {
            hash = (hash + (c - 'a' + 1) * pPow) % prime;
            pPow = (pPow * prime) % prime;
        }
        return hash;
    }

    //method to calculate rolling hash
    public static long recalculateHash(String text, int oldIndex, int patternLength, long oldHash, int prime) {
        long newHash = oldHash - (text.charAt(oldIndex) - 'a' + 1);
        newHash /= prime;
        newHash += (text.charAt(oldIndex + patternLength) - 'a' + 1) * Math.pow(prime, patternLength - 1);
        return newHash;
    }
}
