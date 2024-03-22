import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

public class AnagramGroups {

    public static List<List<String>> groupAnagrams(String[] inputStr) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        // Group strings by their sorted versions
        for (String str : inputStr) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            map.putIfAbsent(sortedStr, new ArrayList<>());
            map.get(sortedStr).add(str);
        }

        // Add groups to result
        for (List<String> group : map.values()) {
            result.add(group);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Enter strings separated by spaces");
        String[] inputStr = scanner.nextLine().split(" ");
        List<List<String>> result = groupAnagrams(inputStr);
        for (List<String> group : result) {
            for (String str : group) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}
