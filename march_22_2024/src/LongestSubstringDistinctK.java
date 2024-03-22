import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringDistinctK {
    public static int longestSubstringLength(String S, int K) {
        int maxLength = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        int left = 0;

        for (int right = 0; right < S.length(); right++) {
            char c = S.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            while (charCount.size() > K) {
                char leftChar = S.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter value of k:");
        int k = scanner.nextInt();
        String S = scanner.next();
        System.out.println(longestSubstringLength(S, k));
        scanner.close();
    }
}
