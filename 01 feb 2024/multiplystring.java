import java.util.*;

public class multiplystring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string1 :");
        String A = scanner.next();
        System.out.println("Enter string1 :");
        String B = scanner.next();
        String result = multiply(A, B);
        System.out.println(result);
    }
    public static String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        //base case
        if(m == 0 || n == 0 || "0".equals(num1) || "0".equals(num2))
            return "0";
        if("1".equals(num1))
            return num2;
        if("1".equals(num2))
            return num1;
        // result can be of max length n+m
        //eg 99*99 = result of length 4
        int[] result = new int[n+m];

        for(int i = m-1; i >=0; --i)
            for(int j = n-1; j>=0; --j){
                int product = (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                //adding previous valuew in result array to product
                product += result[i+j+1];

                //adding the new product into result array
                result[i+j+1] = product % 10;
                result[i+j] += product / 10;
            }

        //generating the result in string
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            //ignoring leading zeroes
            if(sb.length() == 0 && num == 0)
                continue;
            sb.append(num);
        }
        return sb.toString();
    }
}
