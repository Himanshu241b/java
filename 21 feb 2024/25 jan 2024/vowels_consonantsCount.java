import java.util.*;
public class vowels_consonantsCount {
    public static void main(String[] args){
        String s = "abcde%&";
        countOccurances(s);
    }

    public static void countOccurances(String s){
        int vowelsCount = 0;
        int consonantsCount = 0;
        int otherCharsCount = 0;
        Set vowels = new HashSet<Character>();
        vowels.add('a'); 
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) >64 && s.charAt(i) < 91 || s.charAt(i)> 96 && s.charAt(i) <123){ // if it is a character
                // check if its a vowel or consonant
                if(vowels.contains(s.charAt(i)))
                    vowelsCount++;
                else
                    consonantsCount++; 
            }
            else  // if its not a a character
                otherCharsCount++; 
        }
        System.out.println("vowelscount: "+ vowelsCount); 
        System.out.println("consonantsCount: "+ consonantsCount);
        System.out.println("otherCharsCount: "+ otherCharsCount);

    }
}
