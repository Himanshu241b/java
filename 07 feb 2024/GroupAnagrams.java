import java.util.*;
public class GroupAnagrams {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); // for input
        List<List<String>> groups = new ArrayList(); // to store result 
        System.out.println("Enter the number of string");
        int n= scanner.nextInt(); // length of input string
        String[] string = new String[n];
        System.out.println("Enter the strings");
        for(int i=0; i<n;++i){// take input
            string[i] = scanner.next();
        }
        groups = groupAnagrams(string); // call the function
        System.out.println(groups); // print result
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList(); 
        HashMap<String, List<String>> map = new HashMap(); // HashMap to store the sorted string as key and list of string corresponding to it as its value
        
        for(String word : strs){
            char[] s = word.toCharArray(); // convert to char array to sort it
            Arrays.sort(s);
            String sortedString = String.valueOf(s);// convert to string to add to map
            if(!map.containsKey(sortedString))
                map.put(sortedString, new ArrayList()); // if no entry available already
            map.get(sortedString).add(word); // if available than add the word to map 
        }
        map.forEach((k, v)->{ // iterate through map and add the values to result 
            ans.add(v);
        });

        return ans; // return result

    }
}
