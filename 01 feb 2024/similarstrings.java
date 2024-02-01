
import java.util.Scanner;

public class similarstrings {
    
    public static boolean areSimilar(String A, String B) {
        if (A.equals(B)) {
            return true;
        }
        else{
            int mid = A.length() /2;
            String A1 = A.substring(0, mid);
            String A2 = A.substring(mid);
            String B1 = B.substring(0, mid);
            String B2 = B.substring(mid);
        
        if((A1.equals(B1) && A2.equals(B2)) || (A2.equals(B1) && A1.equals(B2)))
                return true;
        return false;
        }
        
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string1:");
        String A = scanner.next();
        System.out.println("Enter string2:");
        String B = scanner.next();
            
            if (areSimilar(A, B)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
       
    }

