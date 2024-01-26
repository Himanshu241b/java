import java.util.Map;
import java.util.HashMap;

public class uniqueChars {
    public static void main(String[] args){
        String s = "abcb";
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i <s.length(); ++i)
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        
            map.forEach((k, val)->{
            if(val == 1)
                System.out.println(k);
        });

    }
}
