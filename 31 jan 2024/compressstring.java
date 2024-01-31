import java.util.*;

public class compressstring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1 = scanner.nextLine();
        char[] chars = str1.toCharArray();
        StringBuilder sb = new StringBuilder();
        if(str1.length() == 1)
            System.out.println(str1);
        for(int i = 1; i < chars.length; i++){
            int count = 1;
            while(i < chars.length && chars[i] == chars[i-1]){
                ++i;
                ++count;
            }
            sb.append(chars[i-1]);
            if(count > 1)
                sb.append((String.valueOf(count)));
            count = 1;
        }
        System.out.println(sb.toString());
    }
}
