import java.util.Scanner;
public class StringtoNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Initialize scanner object 
        System.out.println("Enter the String to convert");
        String s = sc.next(); // take input
        System.out.println("Converted integer is :"+convert(s, s.length()-1)); // print the result

    }
    public static int convert(String s, int i) {
        if(i < 0) // when i is no longer a string index
            return 0;
        return convert(s, i-1) *10 +(s.charAt(i)-'0'); // recursively call for (i-1)th index multiplied 
                                                        //  by 10 and added integer of next index
    }
}
