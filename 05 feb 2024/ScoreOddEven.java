import java.util.Scanner;

public class ScoreOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter elements of array");
        for(int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int score = 0;
        for(int i : a){
            if(i % 2 == 0)
                score += 1;
            else if(i % 2 == 1 && i != 5)
                score += 3;
            else if (i == 5)
                score += 5;
        }
        System.out.println("Score: " + score);
    }
}
