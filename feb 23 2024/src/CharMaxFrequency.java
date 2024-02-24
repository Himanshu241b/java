//imports
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class CharMaxFrequency{
    static char result;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = sc.next();
        char maxFrequency = findMaxFrequencyChar(str);
        System.out.println(result);

    }

    /**
     * returns character that occurs maximum times
     * @param str string to count maximum frequency
     * @return result character that occurs maximum number of times in string
     */
    public static char findMaxFrequencyChar(String str){
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : str.toCharArray())
            map.put(c, map.getOrDefault(c,0)+1);
        int maxFrequency = 0;
        map.forEach((k, v) -> {
            if(maxFrequency < v) {
                result = k;
            }
        });
        return result;
    }
}