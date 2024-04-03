package april_01_2024;

import java.util.Scanner;

public class DeleteMiddleElementStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Number of test cases
        while (T-- > 0) {
            int N = scanner.nextInt(); // Number of elements in the stack
            int[] stack = new int[N + 1];
            for (int i = 0; i <= N; i++) {
                stack[i] = scanner.nextInt(); // Reading stack elements
            }
            deleteMiddleElement(stack, N);
        }
        scanner.close();
    }

    private static void deleteMiddleElement(int[] stack, int N) {
        int middleIndex = (N + 1) / 2;
        for (int i = 0; i <= N; i++) {
            if (i != middleIndex) {
                System.out.print(stack[i] + " ");
            }
        }
        System.out.println();
    }
}
