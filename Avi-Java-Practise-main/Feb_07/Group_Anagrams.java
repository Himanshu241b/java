package Feb_07;

import java.util.*;

public class Group_Anagrams {
    public static void main(String[] args) {
        //Given a collection of string elements stringArray,
        // organize the elements into groups where each group consists of strings that are anagrams of each other.
        // An anagram is defined as a word or phrase that is created by rearranging the letters of another word
        // or phrase, using all original letters exactly once. The solution can present the groups
        // in any sequence.
        //
        //For stringArray = ["eat", "tea", "tan", "ate", "nat", "bat"],
        // the output should be [["bat"], ["nat", "tan"], ["ate", "eat", "tea"]].
        // Each subgroup contains words that are anagrams of each other.


        //taking string inputs in array by user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array");
        int n = sc.nextInt();
        ArrayList<String> arr = new ArrayList<>();

        System.out.println("Provide elements in array");
        while(n > 0)
        {
            arr.add(sc.next());
            n--;
        }

        //solution starts
        Map<String, ArrayList<String>> m = new HashMap<>();

        for(String i: arr)
        {
            //changing string to character arrsys
            char[] chArray = i.toCharArray();
            Arrays.sort(chArray);
            //then converting that array tp string again
            String newWord = new String(chArray);

            if(m.containsKey(newWord)) {
                m.get(newWord).add(i);
            }
            else{
                //as we need to first time add the value array, so need to create that and put i in it
                ArrayList<String> words = new ArrayList<>(); //created list
                words.add(i); //added i
                m.put(newWord, words); //put m[newWord] = words[];
            }
        }

        //resultant array
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        for(Map.Entry<String, ArrayList<String>> i: m.entrySet())
        {
            res.add(i.getValue());
        }
        System.out.println(res);
    }
}
