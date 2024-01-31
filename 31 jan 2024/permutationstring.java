import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class permutationstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> set = new HashSet<>();
        System.out.println("Enter the string 1");
        String str1 = scanner.nextLine();
        System.out.println("Enter the string 1");
        String str2 = scanner.nextLine();
        char[] ch = str1.toCharArray();
        for(char i : ch){
            set.add(i);
        }
        for(int i = 0; i < str2.length(); i++){
            if(!set.contains((Character)str2.charAt(i))){
                System.out.println("Not a permutation");
                return;
            }
        }
        System.out.println("Permutation");

        
    }
}
