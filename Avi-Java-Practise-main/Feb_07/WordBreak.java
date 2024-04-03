package Feb_07;

import java.util.ArrayList;
import java.util.Scanner;

public class WordBreak {
    //Given a string inputString and a list of words wordsList, determine if inputString can be divided into a
    // sequence of one or more words from wordsList, with spaces inserted between words.
    // The same word from wordsList can be used multiple times in the division.
    //
    //For inputString = "Avisoft" and wordsList = ["Avi", "soft"], the function should return true
    // because "Avisoft" can be divided as "Avi soft".

    //For inputString = "jammukashmirjammu" and wordsList = ["jammu", "kashmir"],
    // the function should return true because "jammukashmir" can be divided as "jammu kashmir jammu",
    // and it's allowed to reuse words from wordsList.

    //For inputString = "catsandog" and wordsList = ["cats", "dog", "sand", "and", "cat"],
    // the function should return false since there's no way to divide "catsandog" using the words from wordsList
    // that matches the entire string.

    //The length of inputString is between 1 and 300 characters.
    //The size of wordsList is between 1 and 1000.
    //Each word in wordsList has a length between 1 and 20 characters.
    //inputString and each word in wordsList consist only of lowercase English letters.
    //All words in wordsList are unique.
    //Determine if the given inputString can be fully segmented into a sequence of one or more
    // words from the provided wordsList.

    static boolean solve(String s, int i, ArrayList<String> arr)
    {
        //base case
        if(i >= s.length()) return true;

        for(int j=i+1; j<=s.length(); j++)
        {
            if(arr.contains(s.substring(i, j)) && solve(s, j, arr)) return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //strung s as input
        System.out.println("Enter the string");
        String s = sc.next();

        ArrayList<String> arr = new ArrayList<>();
        System.out.println("Enter the length of array");
        int n = sc.nextInt();

        //array as input
        System.out.println("Provide elements of array");
        while(n-- > 0)
        {
            arr.add(sc.next());
        }

        System.out.println(solve(s, 0, arr));

    }
}
