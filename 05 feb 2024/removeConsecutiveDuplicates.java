import java.util.Scanner;

public class removeConsecutiveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String  s = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        System.out.println(sb);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i-1))
                sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}
