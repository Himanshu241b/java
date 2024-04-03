package Da4_31jan;

import java.util.Scanner;

public class Compress_the_string {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sentence");
        String str = sc.nextLine();

        StringBuilder res = new StringBuilder();

        int count = 1;
        char curr = str.charAt(0);

        for(int i=1; i<str.length(); i++) {
            if(str.charAt(i) == curr) count++;
            else{
                res.append(curr);
                res.append(count);
                curr = str.charAt(i);
                count = 1;
            }
        }
        res.append(curr);
        res.append(count);

        System.out.println(res);

    }
}
