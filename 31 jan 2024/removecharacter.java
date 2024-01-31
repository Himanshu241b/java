import java.util.Scanner;

public class removecharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1 = scanner.nextLine();
        System.out.println("Enter the character to remove");
        char c = scanner.next().charAt(0);
        char[] chararray = str1.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char i : chararray) {
            if(c != i)
                sb.append(i);
    }
    System.out.println(sb.toString());
}
}
