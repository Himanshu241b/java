import java.util.*;

public class highestoccuringcharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1 = scanner.nextLine();
        char[] chars = str1.toCharArray();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : chars){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        char highestOccurringChar = chars[0]; // Initialize with the first character
        int maxFrequency = map.get(highestOccurringChar); // Initialize with the frequency of the first character

        for (char ch : map.keySet()) {
            int frequency = map.get(ch);
            if (frequency > maxFrequency ) {
                highestOccurringChar = ch;
                maxFrequency = frequency;
            }
        }
        System.out.println(highestOccurringChar );
        

    }
}
