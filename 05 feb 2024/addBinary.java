import java.util.*;
public class addBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first binary number: " );
        String num1 = sc.next();
        System.out.println("Enter second binary number: ");
        String num2 = sc.next();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = 0;
            if(i >= 0)
                sum+=num1.charAt(i--)-'0';
            if( j>= 0)
                sum+=num2.charAt(j--)-'0';
            sum+= carry;
            sb.append(sum%2);
            carry = sum/2;
            
        }
        System.out.println(sb.reverse());
    }
}
