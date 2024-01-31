import java.util.Scanner;

public class countwords {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string");
        String str = scanner.nextLine();
        int res = countWords(str);
        System.out.println("count:"+ res);
    }
    public static int countWords(String str) {
        // Split the input string by space and count the number of resulting tokens
        String[] words = str.split(" ");
        return words.length;
    }
}

