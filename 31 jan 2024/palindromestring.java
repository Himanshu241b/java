import java.util.Scanner;

public class palindromestring {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        if(checkpal(str))
            System.out.println("Palindrome");
        else
            System.out.println("Not palindrome");
    }
    public static boolean checkpal(String str){
        str = str.toLowerCase();
        int i = 0;
        int j = str.length()-1;
        while(i++ < j--){
            if(str.charAt(i) != str.charAt(j))
                return false;
    }
    return true;

}
}
