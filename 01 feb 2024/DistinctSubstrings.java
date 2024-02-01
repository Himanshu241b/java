import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DistinctSubstrings {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        count = distinct(s);
        System.out.println("characters to replace:"+count);
    }
    public static int distinct(String s) {
         Map<Character,Integer> map = new HashMap<Character,Integer>();

        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        map.forEach((k, v)->{
            if(v > 1)
                count = count +v-1;
    });
    return count;
    }
}
