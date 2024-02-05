import java.util.Scanner;

public class EqualVowels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the String");
        String s = scanner.nextLine();
        if(checkVowels(s))
            System.out.println("true");
        else
            System.out.println("false");

    }
    public static boolean checkVowels(String s){

        int v1 = 0;
        int v2 = 0;
        for(int i = 0,j = s.length()-1; i < j; i++, --j){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'
             || s.charAt(i) == 'A' || s.charAt(i) =='E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
                ++v1;
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u'
            || s.charAt(i) == 'A' || s.charAt(i) =='E' || s.charAt(i) == 'I' || s.charAt(i) == 'O' || s.charAt(i) == 'U')
                ++v2;
        }
        
        return v1 == v2;
    }
}
