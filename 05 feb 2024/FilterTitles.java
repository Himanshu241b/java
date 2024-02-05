import java.util.Scanner;

public class FilterTitles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        System.out.println("Enter size of string array");
        int n = sc.nextInt();
        String[] titleStrings = new String[n];
        System.out.println("Enter the words of title");
        for(int i = 0; i < n; ++i)
            titleStrings[i] = sc.next();
        for(int i = 0; i < n; ++i){
            
            StringBuilder b = new StringBuilder(titleStrings[i]);
            

            while(Character.isDigit(b.charAt(0)))
                b.deleteCharAt(0);
                
            
            String t = b.substring(0, 1).toUpperCase() + b.substring(1);            

            for(int j = 0; j < t.length();++j){
                if(!Character.isDigit(t.charAt(j)))
                    sb.append(t.charAt(j));
            }
            sb.append(" ");
        }
        System.out.println(sb);

    }
}
